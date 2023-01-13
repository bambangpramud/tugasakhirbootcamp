package com.bcafinance.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2).
                select().
                apis(RequestHandlerSelectors.basePackage("com.bcafinance.ahsspringboot.controllers")).
                paths(PathSelectors.any()).build()
                .apiInfo(apiInfo());
    }

//    ApiInfo(String title,
//    String description,
//    String version,
//    String termsOfServiceUrl,
//    String contactName,
//    String license,
//    String licenseUrl) {
    private ApiInfo apiInfo()
    {
        ApiInfo apiInfo = new ApiInfo(
                "ArchanSpringBootRestAPI",//title
                "Springboot bootcamp BCAF BATCH 1 Archan",//descriptions
                "v1.0",//version
                "Term Of Services URL is On Progress",//termsOfServiceUrl
                new Contact("Archan Habib S","localhost:8080/api","archanhabib11@@gmail.com"),//Contact Name
                "Springboot Open Source License",//license
                "https://spring.io/",//licenseUrl
                Collections.emptyList()
        );
        return apiInfo;
    }

}
