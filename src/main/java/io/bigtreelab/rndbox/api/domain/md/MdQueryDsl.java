package io.bigtreelab.rndbox.api.domain.md;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;

// JPQL 용
@Component
public interface MdQueryDsl {
    String getMdId();
    String getMdCategoryId();
    String getMdColorId();
    String getMdCodyName();
    String getMdCodyDetailCategoryId();
    String getMdCodyDetailColorId();
}
