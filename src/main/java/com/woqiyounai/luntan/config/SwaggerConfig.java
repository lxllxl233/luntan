package com.woqiyounai.luntan.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class SwaggerConfig {

    @Bean
    public Docket creatRestApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(new ApiInfoBuilder().description("博客论坛项目 api")
                        .title("博客论坛项目")
                        .version("1.0.0")
                        .build())
                .select()
                //为当前包路径
                .apis(RequestHandlerSelectors.basePackage("com.woqiyounai.luntan.controller"))
                .paths(PathSelectors.any())
                .build();
    }

}
