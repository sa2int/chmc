package io.bigtreelab.rndbox.api.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

import io.bigtreelab.rndbox.api.utils.DateTimeUtils;
import lombok.Getter;
import lombok.Setter;


@Getter	
@Setter
public abstract class CommonDateDomain implements Serializable {
	

	private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
    
	public CommonDateDomain() {
		this.createdDate = DateTimeUtils.nowFromZone();
		this.updatedDate = DateTimeUtils.nowFromZone();
	}


}