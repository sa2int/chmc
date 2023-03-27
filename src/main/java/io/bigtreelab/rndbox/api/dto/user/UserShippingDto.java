package io.bigtreelab.rndbox.api.dto.user;

import java.io.Serializable;

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
public class UserShippingDto implements Serializable {

    
    /**유저번호*/
	/** 유저아이디 */
	private String userId;
	/**유저명*/
	private String userName;
	/**휴대폰번호*/
	private String cellphone;

}
