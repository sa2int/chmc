package io.bigtreelab.rndbox.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.bigtreelab.rndbox.api.enums.EnumMapper;
import io.bigtreelab.rndbox.api.enums.BannerType;
import io.bigtreelab.rndbox.api.enums.PaymentMethod;
import io.bigtreelab.rndbox.api.enums.PaymentPay;
import io.bigtreelab.rndbox.api.enums.SortType;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
public class EnumMapperConfiguration {

    @Bean
    public EnumMapper enumMapper() {
        EnumMapper enumMapper = new EnumMapper();
		enumMapper.put("JoinType", BannerType.class);
		enumMapper.put("PaymentMethod", PaymentMethod.class);
		enumMapper.put("SortType", SortType.class);
		enumMapper.put("PaymentPay", PaymentPay.class);
        
        log.info("AppConfig enumMapper==> {}", enumMapper.toString());
        
        return enumMapper;
    }
}
