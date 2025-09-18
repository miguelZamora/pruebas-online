package cl.cachoza.web001.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        Server server = new Server();
        server.setUrl("http://localhost:8080");
        server.setDescription("Servidor de Desarrollo");

        Info info = new Info()
            .title("API Users Management")
            .version("1.0.0")
            .description("API para gestión de usuarios WordPress");

        return new OpenAPI()
            .info(info)
            .servers(List.of(server));
    }
}