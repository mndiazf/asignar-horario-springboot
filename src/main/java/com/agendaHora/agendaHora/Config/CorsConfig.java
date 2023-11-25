package com.agendaHora.agendaHora.Config;

import org.apache.catalina.filters.CorsFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
public class CorsConfig {

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.addAllowedOrigin("*"); // Permite solicitudes desde cualquier origen
        config.addAllowedHeader("*"); // Permite cualquier encabezado
        config.addAllowedMethod("*"); // Permite cualquier método (GET, POST, etc.)
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter();
    }
}