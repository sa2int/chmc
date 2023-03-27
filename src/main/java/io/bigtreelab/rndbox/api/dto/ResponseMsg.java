package io.bigtreelab.rndbox.api.dto;

import lombok.Data;

@Data
public class ResponseMsg {
    private String code;
    private String msg;
    private Object data;
    private String instance;
//    private HashMap MapData;
//    private List<CusMap> ListData;



}
