package com.undefined.undefined.feign.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DTOData {
    private String url; // TODO Сейчас тут url, но это надо переделать (не менять саму String giphy)
    private String typeUrl;

    @Override
    public String toString() {
        return "{giphy: " + url + "}\n";
    }


    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (!(obj instanceof DTOData)) return false;
        DTOData oth = (DTOData) obj;
        return oth.typeUrl.equals(typeUrl);
    }
}


