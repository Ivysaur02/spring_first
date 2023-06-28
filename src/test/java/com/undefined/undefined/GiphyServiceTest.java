package com.undefined.undefined;


import com.undefined.undefined.feign.dto.DTOData;
import com.undefined.undefined.service.GiphyService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@SpringBootTest
public class GiphyServiceTest {


    @Autowired
    GiphyService giphyService;

    static DTOData dtoData;

    @BeforeAll
    public static void init(){
        dtoData = new DTOData();

        dtoData.setTypeUrl("rich");
        dtoData.setUrl("url");
    }

    @Test
    void CheckGifSameType(){
        DTOData receivedData = giphyService.getGiphy("rich");
        assertEquals(receivedData, dtoData);
    }

    @Test
    void CheckNotEqualsType(){
        DTOData receivedData = giphyService.getGiphy("broke");
        assertNotEquals(receivedData, dtoData);
    }
}
