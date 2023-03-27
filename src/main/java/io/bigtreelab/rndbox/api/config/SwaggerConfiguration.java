package io.bigtreelab.rndbox.api.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration  { //  extends WebMvcConfigurationSupport

    @Value("${swagger.host}")
    private String host;
    @Value("${swagger.use-swagger}")
    private String useSeagger;

    @Bean
    public Docket randonboxApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .host(host)
                .apiInfo(randonboxApiInfo()) // API Docu 및 작성자 정보 매핑
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any()) // controller package 전부
                //.paths(PathSelectors.ant("/v1/**"))  // controller 패키지 내 v1만 택해서 할수도 있다.
                .build()
                .useDefaultResponseMessages(false) // 기본 세팅값인 200, 401, 402, 403, 404를 사용하지 않는다.
                .enable(Boolean.parseBoolean(useSeagger));
    }

    private ApiInfo randonboxApiInfo() {
        return new ApiInfoBuilder().title("옷 고르기")
                .description("옷 고르기")
                .license("PTS")
                .licenseUrl("pts")
                .version("1.0")
                .build();
    }

//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/swagger-ui/**").addResourceLocations("classpath:/META-INF/resources/webjars/springfox-swagger-ui/");
//        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/springfox-swagger-ui/");
//    }

}
