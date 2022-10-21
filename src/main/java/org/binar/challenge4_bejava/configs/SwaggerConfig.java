package org.binar.challenge4_bejava.configs;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SwaggerConfig {

        @Bean
        public OpenAPI bioskopOpenAPI() {
            return new OpenAPI().info(new Info()
                            .title("Aplikasi Bioskop")
                            .description("REST API Bioskop - Muhammad Rizky Akbar")
                            .version("0.2")

                    ).servers(List.of(new Server().url("https://reservasi-bioskop-rizkyakbar.up.railway.app/")));
        }


}
