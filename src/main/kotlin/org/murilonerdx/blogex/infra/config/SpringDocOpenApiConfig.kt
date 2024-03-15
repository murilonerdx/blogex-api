package org.murilonerdx.blogex.infra.config

import io.swagger.v3.oas.models.Components
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration

class SpringDocOpenApiConfig {
    @Bean
    fun openAPI(): OpenAPI {
        return OpenAPI()
//            .components(
//                Components()
//                    .addSecuritySchemes("security_auth", securityConfig())
//            )
            .info(
                Info()
                    .title("REST API - Blogex")
                    .description("API para cadastrar posts de um blog e informações")
                    .version("v1")
                    .license(License().name("Apache 2.0").url("https://www.apache.org/licenses/LICENSE-2.0"))
                    .contact(Contact().name("Murilo P.S").email("mu-silva@outlook.com"))
            )
    }

//    @Bean
//    fun securityConfig(): SecurityScheme {
//        return SecurityScheme()
//            .description("Informar o token JWT")
//            .type(SecurityScheme.Type.HTTP)
//            .`in`(SecurityScheme.In.HEADER)
//            .name("security_auth")
//            .bearerFormat("JWT")
//            .scheme("bearer")
//    }
}