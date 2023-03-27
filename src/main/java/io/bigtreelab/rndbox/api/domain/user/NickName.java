package io.bigtreelab.rndbox.api.domain.user;

import io.bigtreelab.rndbox.api.domain.CommonDateDomain;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NickName extends CommonDateDomain {
	
	/** 아이디 */
	private Long idx;
	/**닉네임*/
	private String nickName;
	private Long createdBy;
	private Long updatedBy;
	
}