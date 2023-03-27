package io.bigtreelab.rndbox.api.dto.user;

import io.bigtreelab.rndbox.api.domain.user.UserDevice;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.joda.time.DateTime;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserLogRequestDto {

    private String cellphone;
    private String deviceType;
    private DateTime logDate;

}
