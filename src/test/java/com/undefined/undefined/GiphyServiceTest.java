package com.undefined.undefined;


import com.undefined.undefined.feign.dto.DTOData;
import com.undefined.undefined.feign.dto.DTOResponseGiphy;
import com.undefined.undefined.service.GiphyService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.ArgumentMatchers.anyString;

public class GiphyServiceTest extends AbstractTest {


    @Autowired
    GiphyService giphyService;

    static DTOData dtoData;
    static DTOResponseGiphy returnedDTOGiphy;
    static DTOResponseGiphy dtoResponseGiphyNotSame;
    static DTOData notSameData;

    @BeforeAll
    public static void init() {
        dtoData = new DTOData();
        notSameData = new DTOData();
        returnedDTOGiphy = new DTOResponseGiphy();
        dtoResponseGiphyNotSame = new DTOResponseGiphy();
        //это ебучий кринж
        List<DTOData> returnedlist = new ArrayList<>();

        dtoData.setTypeUrl("rich");
        dtoData.setUrl("url");
        for (int i = 0; i < 56; i++) {
            returnedlist.add(dtoData);
        }

        notSameData.setUrl("randurl");
        notSameData.setTypeUrl("Type");
        List<DTOData> returnedNotSamelist = new ArrayList<>();
        for (int i = 0; i < 56; i++) {

            returnedNotSamelist.add(notSameData);
        }

        returnedDTOGiphy.setData(returnedlist);
        dtoResponseGiphyNotSame.setData(returnedNotSamelist);
    }

    @Test
    void CheckGifSameType() {
        Mockito.when(feignClientRequestGiphy.getGiphy(anyString(), anyString())).thenReturn(returnedDTOGiphy);
        DTOData receivedData = giphyService.getGiphy("123");
        assertEquals(receivedData, dtoData);
    }

    @Test
    void CheckNotEqualsType() {
        Mockito.when(feignClientRequestGiphy.getGiphy(anyString(), anyString())).thenReturn(dtoResponseGiphyNotSame);
        DTOData receivedData = giphyService.getGiphy("br");
        assertNotEquals(receivedData, dtoData);
    }
}
