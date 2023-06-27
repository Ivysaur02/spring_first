package com.tritonsy.abstraction.controller;

import com.tritonsy.abstraction.api.DecodeApi;
import com.tritonsy.abstraction.service.QrCodeService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@AllArgsConstructor
@Tag(name = "Decoding", description = "decode API")
public class DecodeController implements DecodeApi {
    private final QrCodeService service;

    @Override
    public ResponseEntity<Void> decodeFile(MultipartFile file) {
        service.decode(file);
        return ok().build();
    }
}
