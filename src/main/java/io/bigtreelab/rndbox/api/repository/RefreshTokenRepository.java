package io.bigtreelab.rndbox.api.repository;

import io.bigtreelab.rndbox.api.domain.security.RefreshToken;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RefreshTokenRepository { 
	int save(RefreshToken refreshToken);
	RefreshToken findByUserNo(Long userNo);
	
}
