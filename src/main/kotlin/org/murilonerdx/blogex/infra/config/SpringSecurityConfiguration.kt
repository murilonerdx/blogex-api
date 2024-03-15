package org.murilonerdx.blogex.infra.config

import org.apache.catalina.webresources.TomcatURLStreamHandlerFactory.disable
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.http.HttpRequest
import org.springframework.security.config.Customizer
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.csrf.CookieCsrfTokenRepository
import org.springframework.security.web.util.matcher.AntPathRequestMatcher.antMatcher
import org.springframework.web.servlet.config.annotation.EnableWebMvc


@EnableWebSecurity
@EnableWebMvc
@Configuration
class SpringSecurityConfiguration {
    @Bean
    fun filterChain(http: HttpSecurity): SecurityFilterChain {
        http.csrf{c -> c.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())}
            .authorizeHttpRequests { authz ->
                authz.requestMatchers(
                    antMatcher(HttpMethod.GET, "/"),
                    antMatcher(HttpMethod.POST, "/api/v1/post"),
                    antMatcher(HttpMethod.GET, "/api/v1/post"),
                    antMatcher(HttpMethod.PUT, "/api/v1/post"),
                    antMatcher(HttpMethod.DELETE, "/api/v1/post")).permitAll().anyRequest().authenticated()
            }
            .oauth2Login { oauth2Login ->
                oauth2Login.loginPage("/oauth2/authorization/github")
            }
            .formLogin(Customizer.withDefaults())
        return http.build()
    }
}