package com.qb.ad.base.conf;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;


@Configuration
@EnableSwagger2
public class SwaggerConf extends WebMvcConfigurationSupport {

    /**
     * 设置一个开关，生产版本为false，关闭swagger
     */
    @Value("${swagger.ebable}")
    private boolean ebable;

    @Bean
    public Docket api() {

        return new Docket(DocumentationType.SWAGGER_2)
                .useDefaultResponseMessages(false)
                .enable(ebable)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
//                .apis(RequestHandlerSelectors.any())
//                .apis(basePackage("com.qb.ad.dubbo.web.ctrl"+splitor+"com.qb.ad.admin.web.ctrl"+splitor+"com.qb.ad.dubbo.web.api"))
//                .apis(RequestHandlerSelectors.basePackage("com.qb.ad.admin.web.ctrl"))
                .paths(PathSelectors.regex("^.*(?!login|api).*$"))
                .paths(PathSelectors.any())
                .build();
//                .securitySchemes(securitySchemes())
//                .securityContexts(securityContexts());
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("安泊基础服务api接口文档")
                .description("restful 风格接口")
                .version("1.0")
                .build();
    }

//    private List<ApiKey> securitySchemes() {
//        ApiKey apiKey = new ApiKey("Authorization", "Access-Token", "header");
//        List<ApiKey> apiKeyList = new ArrayList<>();
//        apiKeyList.add(apiKey);
//        return apiKeyList;
//    }
//    private List<SecurityContext> securityContexts() {
//        SecurityContext securityContext = SecurityContext.builder()
//                .securityReferences(defaultAuth())
////                .forPaths(PathSelectors.regex("^(?!/user).*$"))
////                .forPaths(PathSelectors.regex("^.*(?!login|api).*$"))
//                .forPaths(PathSelectors.regex("^.*(?!login|api).*$"))
//                .build();
//
//        List<SecurityContext> securityContextList = new ArrayList<>();
//        securityContextList.add(securityContext);
//        return securityContextList;
//    }
//
//    List<SecurityReference> defaultAuth() {
//        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
//        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
//        authorizationScopes[0] = authorizationScope;
//        SecurityReference securityReference = new SecurityReference("Authorization", authorizationScopes);
//        List<SecurityReference> securityContextList = new ArrayList<>();
//        securityContextList.add(securityReference);
//        return securityContextList;
//    }

    /**
     * 一定要写这个方法，不然访问swagger-ui.html页面会404
     * @param registry
     */
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**").
                addResourceLocations("classpath:/META-INF/resources/").
                setCachePeriod(0);
    }


}
