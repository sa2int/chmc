package io.bigtreelab.rndbox.api.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseResult<T> extends CommonResult {
    private T data;

    public void setData(T data) {
        this.data = data;
    }

}
