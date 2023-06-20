package sg.edu.nus.iss.paf21_workshopnorthwind.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class OpenAPIConfig {
    
    @Bean
    public OpenAPI openApi() {
        return new OpenAPI()
                .info(new Info()
                .title("PAF21 WORKSHOP API")
                .description("PAF21 WORKSHOP")
                .version("version 1.0"));
    }
}
