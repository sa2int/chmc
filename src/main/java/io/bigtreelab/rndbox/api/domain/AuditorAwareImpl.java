package io.bigtreelab.rndbox.api.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Optional;

import static io.bigtreelab.rndbox.api.utils.Constants.SYSTEM_USER;

@RequiredArgsConstructor
@Component
public class AuditorAwareImpl implements AuditorAware<Long> {

    @Override
    public Optional<Long> getCurrentAuditor () {
        String adminNo = SecurityContextHolder.getContext().getAuthentication().getName();
        if(adminNo==null){
            return null;
        }
        return Optional.ofNullable(Long.parseLong(String.valueOf(SYSTEM_USER)));
    }
}
