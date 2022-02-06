package br.com.cast.avaliacao.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;
import java.util.List;

@Configuration
@EnableSwagger2
public class SwaggerConfig extends WebMvcConfigurationSupport {
    @Bean
    public Docket api() {
    	return new Docket(DocumentationType.SWAGGER_2)
    	        .select()
    	        .apis(RequestHandlerSelectors.basePackage("br.com.cast.avaliacao.controller"))
    	        .paths(PathSelectors.any())
                .build()
                .apiInfo(metaData())
                .useDefaultResponseMessages(false)
    	        .globalResponseMessage(RequestMethod.GET, responseMessageForGET());
    }

    private ApiInfo metaData() {
        return new ApiInfoBuilder()
                .title("castgroup")
                .description("Documentação da API do castgroup teste.")
                .version("1.0")
                .license("Link do Projeto")
                .licenseUrl("https://github.com/G3Quixabeira/castgroup")
                .build();
    }

    private List<ResponseMessage> responseMessageForGET()
    {
    	return Arrays.asList(new ResponseMessageBuilder()
                .code(500)
                .message("500 message")
                .responseModel(new ModelRef("string"))
                .build(),
            new ResponseMessageBuilder()
                .code(404)
                .message("Not Found!")
                .build());
    }

    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**")
         .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }
}