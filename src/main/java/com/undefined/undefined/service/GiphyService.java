package com.undefined.undefined.service;

import com.undefined.undefined.feign.FeignClientRequestGiphy;
import com.undefined.undefined.feign.dto.DTOResponseGiphy;
import com.undefined.undefined.feign.dto.DTOData;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@RequiredArgsConstructor
@Slf4j
public class GiphyService {
    @Value("${giphy.app-key}")
    private String apiKey;
    private final String DEFAULT_GIPHY_TYPE = "lost";  // Запрос для поиска giphy


    private final FeignClientRequestGiphy clientGiphy;

    public DTOData getGiphy() {
        try {
            DTOResponseGiphy responseGiphy = clientGiphy.getGiphy(apiKey, DEFAULT_GIPHY_TYPE);

            Random random = new Random();
            int randomIndex = random.nextInt(50);
            responseGiphy.getData().get(randomIndex).setTypeUrl(DEFAULT_GIPHY_TYPE);

            return responseGiphy.getData().get(randomIndex);
        } catch (Exception e) {
            log.debug("Catch smth");
            throw new RuntimeException("Kek");
        }
    }
    public DTOData getGiphy(String giphyType) {
        try {
            DTOResponseGiphy responseGiphy = clientGiphy.getGiphy(apiKey, giphyType);


            Random random = new Random();
            int randomIndex = random.nextInt(50);
            responseGiphy.getData().get(randomIndex).setTypeUrl(giphyType);
            return responseGiphy.getData().get(randomIndex);
        } catch (Exception e) {
            log.debug("Catch smth");
            throw new RuntimeException("Kek");
        }
    }
}
