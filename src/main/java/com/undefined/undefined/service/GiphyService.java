//package com.undefined.undefined.service;
//
//import com.undefined.undefined.feign.FeignClientRequestCurrency;
//import com.undefined.undefined.feign.FeignClientRequestGiphy;
//import com.undefined.undefined.feign.dto.DTOData;
//import com.undefined.undefined.feign.dto.DTOResponseCurrency;
//import com.undefined.undefined.feign.dto.DTOResponseGiphy;
//import feign.Feign;
//import feign.gson.GsonDecoder;
//import lombok.AllArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.stereotype.Service;
//
//import java.util.Random;
//
//@Service
//@AllArgsConstructor
//@Slf4j
//public class GiphyService {
//    private final String apiKey = "AOk1bWf4UKBCe59mkHeHLNhweaQWNJiw"; // Код Даниила (НЕ ТРОГАТЬ)
//    private final String DefaultGiphyType = "lost";  // Запрос для поиска giphy
//
//
//    private final FeignClientRequestGiphy clientGiphy = Feign.builder()
//            .decoder(new GsonDecoder()) // JSON декодер, чтобы работать с JSON
//            .target(FeignClientRequestGiphy.class, "https://api.giphy.com/v1/");
//
//    public DTOData getGiphy() {
//        try {
//            DTOResponseGiphy responseGiphy = clientGiphy.getGiphy(apiKey, DefaultGiphyType);
//
//            Random random = new Random();
//            int randomIndex = random.nextInt(50);
//
//            return responseGiphy.getData().get(randomIndex);
//        } catch (Exception e) {
//            log.debug("Catch smth");
//            throw new RuntimeException("Kek");
//        }
//    }
//    public DTOData getGiphy(String giphyType) {
//        try {
//            DTOResponseGiphy responseGiphy = clientGiphy.getGiphy(apiKey, giphyType);
//
//            Random random = new Random();
//            int randomIndex = random.nextInt(50);
//
//            return responseGiphy.getData().get(randomIndex);
//        } catch (Exception e) {
//            log.debug("Catch smth");
//            throw new RuntimeException("Kek");
//        }
//    }
//}
