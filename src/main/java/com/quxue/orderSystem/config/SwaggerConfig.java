package com.quxue.orderSystem.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
@EnableOpenApi //支持swagger3的注解
@EnableWebMvc //需要基于springMVC
public class SwaggerConfig {

    @Bean
    public Docket getDocket() {
        return new Docket(DocumentationType.OAS_30)
                .apiInfo(getApiInfo())
                .select()
                .build();
    }


    public ApiInfo getApiInfo() {
        return new ApiInfoBuilder()
                .version("1.0")
                .contact(new Contact("harusame", "https://github.com/oharusameo", "ggzst321@outlook.com"))
                .title("外卖系统API文档")
                .description("外卖系统")
                .build();
    }

}
