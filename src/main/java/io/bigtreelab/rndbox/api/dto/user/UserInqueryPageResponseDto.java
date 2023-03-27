package io.bigtreelab.rndbox.api.dto.user;

import java.util.List;

import io.bigtreelab.rndbox.api.paging.Paging;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserInqueryPageResponseDto {

	private Paging paging;
	private List<UserInqueryDto> list;
}
