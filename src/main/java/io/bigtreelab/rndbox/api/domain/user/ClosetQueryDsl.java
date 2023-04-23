package io.bigtreelab.rndbox.api.domain.user;

import org.springframework.stereotype.Component;

// JPQL 용
@Component
public interface ClosetQueryDsl {
    String getClosetId();
    String getUserNo();
    String getCategoryId();
    String getColorId();
    String getCategoryPId();
}
