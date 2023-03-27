package io.bigtreelab.rndbox.api.dto.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDeviceRequestDto {

    private Long userNo;
    private String deviceModel;
    private String deviceType;
    private String osVersion;
    private String serialNo;
    private String delYn;
}
