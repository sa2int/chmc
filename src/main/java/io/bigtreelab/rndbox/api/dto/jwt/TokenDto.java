package io.bigtreelab.rndbox.api.dto.jwt;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TokenDto {
	@JsonIgnore
    private String grantType;
    private String accessToken;
    private String refreshToken;
	private String accessTokenExpireDate;
	private String userid;
}