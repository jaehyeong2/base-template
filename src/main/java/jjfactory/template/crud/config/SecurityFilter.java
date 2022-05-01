package jjfactory.template.crud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Collections;
import java.util.List;

@Configuration
public class SecurityFilter {

    @Bean
    public CorsFilter corsFilter(){
        List<String> list = Collections.singletonList("*");
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();

        config.setAllowCredentials(true);
        config.setAllowedOrigins(list);
        config.setAllowedHeaders(list);
        config.setAllowedMethods(list);
        source.registerCorsConfiguration("/api/**",config);
        return new CorsFilter(source);
    }
}
