package com.hackathon.veteranhelper.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.server.resource.authentication.DelegatingJwtGrantedAuthoritiesConverter;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringConfig {
//    @Bean
//    SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
//
//        DelegatingJwtGrantedAuthoritiesConverter authoritiesConverter =
//                // Using the delegating converter multiple converters can be combined
//                new DelegatingJwtGrantedAuthoritiesConverter(
//                        // First add the default converter
//                        new JwtGrantedAuthoritiesConverter(),
//                        // Second add our custom Keycloak specific converter
//                        new KeycloakJwtRolesConverter());
//
//        // Set up http security to use the JWT converter defined above
//        httpSecurity.oauth2ResourceServer().jwt().jwtAuthenticationConverter(
//                jwt -> new JwtAuthenticationToken(jwt, authoritiesConverter.convert(jwt)));
//
//        return httpSecurity..build();
//    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeRequests(authorize -> authorize.anyRequest().permitAll());
        return http.build();
    }
}
