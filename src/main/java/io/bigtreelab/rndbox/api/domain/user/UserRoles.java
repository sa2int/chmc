package io.bigtreelab.rndbox.api.domain.user;

import io.bigtreelab.rndbox.api.domain.CommonDomain;
import lombok.Builder;
import lombok.Getter;


@Getter
public class UserRoles extends CommonDomain{
    private Long userNo;
    private String role;
    

	@Builder
	public UserRoles(Long userNo,  String role) {
		super(userNo);
		this.userNo = userNo;
		this.role = role;
	}
    
    

}