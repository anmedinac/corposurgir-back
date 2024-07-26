package com.corposurgir.back.configuracion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

@Configuration
public class AppConfig {

    /**
     * Le estoy diciendo a spring boot que abra y tenga los metodos permitidos para que las aplicaciones puedan
     * ingresar a el, ya sea con las funciones GET, PUT.... Tambien le registro los headers
     * Tambien le puedo decir que el unico canal de conexión sera la ip de mi front, http://localhost:4200 en
     * este caso para ustedes sería colocar la url de su front, y sera la unica que se pueda conectar a nuestro back
     */
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowedOrigins(Arrays.asList("http://localhost:4200", "*"));
        config.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        config.setAllowCredentials(true);
        config.setAllowedHeaders(Arrays.asList("Content-Type", "Authorization"));
        UrlBasedCorsConfigurationSource cors = new UrlBasedCorsConfigurationSource();
        cors.registerCorsConfiguration("/**", config);
        return cors;
    }
}
