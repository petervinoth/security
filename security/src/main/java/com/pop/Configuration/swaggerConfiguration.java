package com.pop.Configuration;
import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;




@Configuration
@EnableSwagger2
public class swaggerConfiguration {
	
	
	 @Bean
	    public Docket api() {
	        return new Docket(DocumentationType.SWAGGER_2).select()
	                .apis(Predicates.not(RequestHandlerSelectors.basePackage("org.springframework.boot")))
	                .paths(PathSelectors.any()).build().apiInfo(apiInfo());
	    }

	    private ApiInfo apiInfo() {
	        return new ApiInfo("Grootan employee data", "Create,update and Delete the Employee records",
	                "1.0.0", "urn:tos", ApiInfo.DEFAULT_CONTACT, "Licensed to Grootan", "https://www.Grootan.com",
	                new ArrayList<VendorExtension>());
	    }


}
