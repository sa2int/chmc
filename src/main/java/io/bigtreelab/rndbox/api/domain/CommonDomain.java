package io.bigtreelab.rndbox.api.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

import io.bigtreelab.rndbox.api.utils.DateTimeUtils;
import lombok.Getter;
import lombok.Setter;


@Getter	
@Setter
public abstract class CommonDomain implements Serializable {
	

    private Long  createdBy;
	private Long  updatedBy;
	private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
    
	public CommonDomain(Long userNo) {
		this.createdBy = userNo;
		this.updatedBy = userNo;
		this.createdDate = DateTimeUtils.nowFromZone();
		this.updatedDate = DateTimeUtils.nowFromZone();
	}


}