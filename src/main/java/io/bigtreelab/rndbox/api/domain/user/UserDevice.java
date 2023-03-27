package io.bigtreelab.rndbox.api.domain.user;

import io.bigtreelab.rndbox.api.domain.CommonDateDomain;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDevice extends CommonDateDomain {

    private Long userNo;
    private String deviceModel;
    private String deviceType;
    private String osVersion;
    private String appVersion;
    private String serialNo;
    private String deviceToken;
    private String delYn;
    private Long createdBy;
    private Long updatedBy;
}
