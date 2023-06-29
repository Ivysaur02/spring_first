package com.undefined.undefined.feign.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class DTOResponseGiphy {
    private List<DTOData> data;

    public void addNewDTOData(DTOData dtoData){
        data.add(dtoData);
    }
}
