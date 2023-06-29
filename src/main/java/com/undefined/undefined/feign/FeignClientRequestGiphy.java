package com.undefined.undefined.feign;

import com.undefined.undefined.config.FeignConfig;
import com.undefined.undefined.feign.dto.DTOResponseGiphy;
import feign.Headers;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.FeignClientsConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
        name = "giphy-service",
        url = "${url.giphy}",
        path = "v1",
        primary = false,
        configuration = FeignConfig.class)
public interface FeignClientRequestGiphy {
    @GetMapping("/gifs/search?api_key={api_key}&limit=50&q={giphyType}")
        // Тип, который мы ожидаем получить в ответе
    DTOResponseGiphy getGiphy(
            @PathVariable("api_key") String apiKey, // В url вместо {date} подставить string даты
            @PathVariable("giphyType") String giphyType
    );
}
