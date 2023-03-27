package io.bigtreelab.rndbox.api.dto.user;

import java.math.BigDecimal;

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
public class DashboardResponseDto {

	private UserResponseDto user;
	private BigDecimal mileage;
}
