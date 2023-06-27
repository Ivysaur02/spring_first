package com.tritonsy.abstraction.service;


import com.google.zxing.ChecksumException;
import com.google.zxing.FormatException;
import com.tritonsy.abstraction.repository.DecodeInfoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
//@EnableAutoConfiguration(exclude = {
//        DataSourceAutoConfiguration.class,
//        DataSourceTransactionManagerAutoConfiguration.class,
//        HibernateJpaAutoConfiguration.class})
class QrCodeServiceTest extends AbstractTest {

    @Autowired
    private QrCodeService qrCodeService;

    @MockBean
    DecodeInfoRepository decodeInfoRepository;

    private final File CORRECT_QR_CODE = new File(Objects.requireNonNull(Thread.currentThread().getContextClassLoader().getResource("qr/correct-qr-code.png")).getFile());
    private final File INCORRECT_QR_CODE = new File(Objects.requireNonNull(Thread.currentThread().getContextClassLoader().getResource("qr/incorrect-qr-code.png")).getFile());

    /**
     * На вход подается валидное изображение с QR кодом
     * О.Р. строка с данными о покупке
     * FYI:
     * t=20201115T110600 — дата и время, указанные на чеке;
     * s=1226.00 — стоимость покупки;
     * fn=9289440300714186 — фискальный номер;
     * i=140396 — фискальный документ;
     * fp=766295339 — фискальный признак документа.
     */
    @Test
    void decodeCorrectQrCode() throws FormatException, ChecksumException, IOException {
        //given
        String qrCodeInfo = qrCodeService.decodeQRCode(CORRECT_QR_CODE);
        //when
        String expectedResult = "t=20201115T110600&s=1226.00&fn=9289440300714186&i=140396&fp=766295339&n=1";
        //then
        assertEquals(expectedResult, qrCodeInfo);
    }

    /**
     * На вход подается невалидное изображение с QR кодом
     * О.Р. после выполнения метода возвращаетя null
     */
    @Test
    void decodeIncorrectQrCode() throws FormatException, ChecksumException, IOException {
        //given
        String qrCodeInfo = qrCodeService.decodeQRCode(INCORRECT_QR_CODE);

        //then
        assertNull(qrCodeInfo);
    }
}
