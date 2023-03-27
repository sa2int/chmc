package io.bigtreelab.rndbox.api.dto;

import io.bigtreelab.rndbox.api.domain.EnumModel;

public class EnumValueDto {
	
    private String code;
    private String codeName;

 
    public EnumValueDto(EnumModel enumModel) {
    	code = enumModel.getValue();
    	codeName = enumModel.getCodeName();
    }

    public String getCode() {
        return code;
    }
    
    public String getCodeName() {
        return codeName;
    }
}
