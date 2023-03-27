package io.bigtreelab.rndbox.api.domain.user;

import io.bigtreelab.rndbox.api.domain.CommonDateDomain;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.joda.time.DateTime;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserLog extends CommonDateDomain {

    private Long userNo;
    private LocalDateTime logDate;
    private String logIp;
    private String loginSuccessYn;
    private String logOsInfo;
    private String browserInfo;
    private Long createdBy;
    private Long updatedBy;

}
