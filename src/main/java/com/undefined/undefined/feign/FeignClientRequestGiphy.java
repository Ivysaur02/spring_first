package com.undefined.undefined.feign;

import com.undefined.undefined.feign.dto.DTOResponseGiphy;
import feign.Headers;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.FeignClientsConfiguration;


@FeignClient(url = "${url.giphy}",
        value = "giphy-feign",
        path = "v1",
        configuration = FeignClientsConfiguration.class)
public interface FeignClientRequestGiphy {
    @RequestLine("GET /gifs/search?api_key={apiKey}&limit=50&q={giphyType}")
    @Headers("Content-Type: application/json")
        // Тип, который мы ожидаем получить в ответе
    DTOResponseGiphy getGiphy(
            @Param("apiKey") String apiKey, // В url вместо {date} подставить string даты
            @Param("giphyType") String giphyType
    );
}
