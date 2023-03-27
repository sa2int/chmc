package io.bigtreelab.rndbox.api.config;

import io.bigtreelab.rndbox.api.domain.AuditorAwareImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;

@Configuration
public class JpaAuditConfiguration {
    @Bean
    public AuditorAware<Long> auditorProvider() {
        return new AuditorAwareImpl();
    }
}
