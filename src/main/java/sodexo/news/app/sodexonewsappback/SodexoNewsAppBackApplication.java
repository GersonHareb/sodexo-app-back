package sodexo.news.app.sodexonewsappback;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Collections;

@SpringBootApplication
public class SodexoNewsAppBackApplication {

	public static void main(String[] args) {
		SpringApplication.run(SodexoNewsAppBackApplication.class, args);
	}

	@Bean
	public OpenAPI configuracionAPI(){
		return new OpenAPI().info(
				new Info()
						.title("Sodexo News API")
						.version("1.0")
						.description("Entregable para entrevista Sodexo, Mapeo de aplicacion de noticias sobre el espacio, comprende algunas acciones CRUD y consumo de API externa, la cual se guarda en nuestra propia API.")
		);
	}



}
