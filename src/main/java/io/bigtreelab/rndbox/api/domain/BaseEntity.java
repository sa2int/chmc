package io.bigtreelab.rndbox.api.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

import static io.bigtreelab.rndbox.api.utils.Constants.SYSTEM_USER;

@Getter
@MappedSuperclass
@EntityListeners (AuditingEntityListener.class)
public class BaseEntity {

    @CreatedDate
    @Column(name = "created_date", updatable = false)
    private LocalDateTime createdDate;

    @LastModifiedDate
    @Column(name = "updated_date")
    private LocalDateTime updatedDate;

    @CreatedBy
    @Column(name = "created_by",updatable = false)
    private Long createdBy = SYSTEM_USER;

    @LastModifiedBy
    @Column(name = "updated_by",updatable = true)
    private Long updatedBy = SYSTEM_USER;

}
