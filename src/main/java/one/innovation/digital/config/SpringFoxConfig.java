package one.innovation.digital.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SpringFoxConfig implements WebMvcConfigurer{
	
	// @formatter:off
 
	@Bean
	public Docket apiDocket() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("one.innovation.digital.api"))
				.build()
				.apiInfo(apiInfo())
				.tags(new Tag("Categoria de Usuário", "Gerencia as categoria do Usuário"))
				.tags(new Tag("Movimentação", "Gerencia movimentações"))
				.tags(new Tag("Jornda de trabalho", "Gerencia Jornda de trabalho"))
				.tags(new Tag("Banco de Horas", "Gerencia Banco de Horas"))
				.tags(new Tag("Calendario", "Gerencia Calendarios"))
				.tags(new Tag("Ocorrencia", "Gerencia Ocorrencias"))
				.tags(new Tag("Localidade", "Gerencia Localidades"))
				.tags(new Tag("Nivél de acesso", "Gerencia Nivél de acesso"))
				.tags(new Tag("Tipo de data", "Gerencia Tipo de data"));
	}
	
	public ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("Controle de Ponto API")
				.description("API aberta para clientes")
				.version("1")
				.contact(new Contact("Apssytem", "77 99857-9024", "adilson.curso@yahoo.com.b"))
				.build();
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("swagger-ui.html")
			.addResourceLocations("classpath:/META-INF/resources/");
		
		registry.addResourceHandler("/webjars/**")
			.addResourceLocations("classpath:/META-INF/resources/webjars/");
	}

	// @formatter:on
}
