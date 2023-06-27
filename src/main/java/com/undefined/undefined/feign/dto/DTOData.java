package com.undefined.undefined.feign.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DTOData {
    private String url; // TODO Сейчас тут url, но это надо переделать (не менять саму String giphy)

    @Override
    public String toString(){
        return "{giphy: " + url + "}\n";
    }
}


