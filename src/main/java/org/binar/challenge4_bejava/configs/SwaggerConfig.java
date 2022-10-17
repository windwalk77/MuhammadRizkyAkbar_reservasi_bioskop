package org.binar.challenge4_bejava.configs;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class SwaggerConfig {

        @Bean
        public OpenAPI bioskopOpenAPI() {
            return new OpenAPI().info(new Info()
                            .title("Aplikasi Bioskop")
                            .description("REST API Bioskop - Muhammad Rizky Akbar")
                            .version("0.2")
                    );
        }


}
