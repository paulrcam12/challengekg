/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pr.personal.challengekg.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.OAuthFlow;
import io.swagger.v3.oas.models.security.OAuthFlows;
import io.swagger.v3.oas.models.security.Scopes;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author PAULRCAMDELL
 */
@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .components(new Components()
                .addSecuritySchemes("spring_oauth", new SecurityScheme()
                        .type(SecurityScheme.Type.OAUTH2)
                        .description("Oauth2 flow")
                        .flows(new OAuthFlows()
                                .clientCredentials(new OAuthFlow()
                                        .tokenUrl("http://localhost:8080" + "/oauth/token")
                                        )))
        )
            .security(Arrays.asList(
                new SecurityRequirement().addList("spring_oauth")))
                .info(new Info()
                        .title("Challenge Kruger Corp Application API")
                        .description("Reto de Kruger Corp desarrollando una API.")
                        .termsOfService("terms")
                        .contact(new Contact().email("paulrcam12@gmail.com"))
                        .license(new License().name("GNU"))
                        .version("1.0")
                );
    }
}
