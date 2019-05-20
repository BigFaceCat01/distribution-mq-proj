package com.hxb.mq.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Created by huang xiao bao
 * @date 2019-04-24 11:29:32
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {

	@Bean
	public Docket createRestApi() {
		//添加head参数start
		ParameterBuilder userIdBuilder = new ParameterBuilder();
		List<Parameter> pars = new ArrayList<Parameter>();
		Parameter userIdParam = userIdBuilder.name("X-AUTH-USERID")
				.description("userId")
				.modelRef(new ModelRef("string"))
				.parameterType("header")
				.required(false)
				.build();
		pars.add(userIdParam);
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo())
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.hxb.mq.controller"))
				.paths(PathSelectors.any())
				.build()
				.globalOperationParameters(pars);
	}


	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("分布式事务一致性")
				.description("分布式事务一致性")
				.version("1.0.0")
				.build();
	}

}