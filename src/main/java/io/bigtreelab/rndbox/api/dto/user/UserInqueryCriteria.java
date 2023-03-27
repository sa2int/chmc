package io.bigtreelab.rndbox.api.dto.user;

import io.bigtreelab.rndbox.api.paging.Criteria;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UserInqueryCriteria  extends Criteria{

	@ApiModelProperty(required = true, value = "", example = "", hidden = true)
	private Long userNo;


}
