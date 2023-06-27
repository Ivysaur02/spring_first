package com.undefined.undefined.FeignApi;

import feign.Headers;
import feign.Param;
import feign.RequestLine;

public interface ApiClientGiphy {
    @RequestLine("GET /search?api_key={apiKey}&limit=50&q={giphyType}")
    @Headers("Content-Type: application/json") // Тип, который мы ожидаем получить в ответе
    ApiResponseGiphy getGiphy(
            @Param("apiKey") String apiKey, // В url вместо {date} подставить string даты
            @Param("giphyType") String giphyType
    );
}
