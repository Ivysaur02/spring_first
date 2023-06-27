package com.tritonsy.abstraction.service;

import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import com.tritonsy.abstraction.model.DecodeInfo;
import com.tritonsy.abstraction.repository.DecodeInfoRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.util.EnumMap;
import java.util.Objects;

@Service
@Transactional
@RequiredArgsConstructor
public class QrCodeService {
    private static final Logger logger = LoggerFactory.getLogger(QrCodeService.class);
    private final DecodeInfoRepository repository;

    public String decodeQRCode(File qrCodeImage) throws FormatException, ChecksumException, IOException {
        BufferedImage bufferedImage = ImageIO.read(qrCodeImage);
        LuminanceSource source = new BufferedImageLuminanceSource(bufferedImage);
        BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
        Reader reader = new MultiFormatReader();
        EnumMap<DecodeHintType, Object> hint = new EnumMap<>(DecodeHintType.class);
        hint.put(DecodeHintType.TRY_HARDER, BarcodeFormat.CODE_39);
        try {
            Result result = reader.decode(bitmap, hint);
            logger.info("Barcode was successfully resolved");
            return result.getText();
        } catch (NotFoundException e) {
            logger.error("Barcode doesnt exists on photo/cannot read barcode");
            return null;
        }
    }

    public void decode(MultipartFile qrCodeImage) {
        File convertedFile;
        try {
            convertedFile = convert(qrCodeImage);
        } catch (IOException e) {
            throw new RuntimeException("Error during conversion");
        }
        String decodedBarcode;
        try {
            decodedBarcode = decodeQRCode(convertedFile);
        } catch (ChecksumException e) {
            throw new RuntimeException("Error during decoding" + e);
        } catch (IOException e) {
            throw new RuntimeException("Error during decoding" + e);
        } catch (FormatException e) {
            throw new RuntimeException("Error during decoding" + e);
        }
        DecodeInfo decodeInfo = new DecodeInfo();
        decodeInfo.setDecodedBarcode(decodedBarcode);
        decodeInfo.setFileName(convertedFile.getName());
        try {
            Files.delete(convertedFile.toPath());
        } catch (IOException e) {
            throw new RuntimeException("Error during deleting file" + e);
        }
        save(decodeInfo);
    }

    public DecodeInfo save(DecodeInfo decodeInfo) {
        return repository.save(decodeInfo);
    }

    public File convert(MultipartFile file) throws IOException {
        File convFile = new File(Objects.requireNonNull(file.getOriginalFilename()));
        boolean alreadyExists = convFile.createNewFile();
        if (alreadyExists) {
            try (FileOutputStream fos = new FileOutputStream(convFile)) {
                fos.write(file.getBytes());
            }
        } else {
            throw new FileAlreadyExistsException(String.format("File with name %s already exists", file.getOriginalFilename()));
        }
        return convFile;
    }
}
