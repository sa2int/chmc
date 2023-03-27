package io.bigtreelab.rndbox.api.domain.security;


import io.bigtreelab.rndbox.api.domain.CommonDomain;
import lombok.Builder;
import lombok.Getter;



@Getter

public class RefreshToken extends CommonDomain{

   
    private String id;
    private Long userNo;
    private String token;
    
    
    public RefreshToken updateToken(String token) {
        this.token = token;
        return this;
    }

    public RefreshToken(Long userNo) {
		super(userNo);
	}

	@Builder
    public RefreshToken(Long userNo, String token) {
    	super(userNo);
        this.userNo = userNo;
        this.token = token;
    }

}