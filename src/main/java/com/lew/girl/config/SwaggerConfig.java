package com.lew.girl.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 *
 */

@Configuration
@EnableSwagger2
class SwaggerConfig {
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.lew.girl"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("展厅内容管理系统-巡航版-接口 RESTful APIs")
                .description("RESTful 风格的接口文档，内容详细，极大的减少了前后端的沟通成本，同时确保代码与文档保持高度一致，极大的减少维护文档的时间。该文档由springboot利用swagger构建")
                .contact(new Contact("RunLew", "https://lurunhong.com", "runhonglu@gmail.com"))
                .version("1.0.0")
                .build();
    }
}
