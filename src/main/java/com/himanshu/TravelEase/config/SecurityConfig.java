package com.himanshu.TravelEase.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.authority.mapping.GrantedAuthoritiesMapper;
import org.springframework.security.oauth2.core.user.OAuth2UserAuthority;
import org.springframework.security.web.SecurityFilterChain;

import java.util.HashSet;
import java.util.Set;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorizeRequests ->
                        authorizeRequests
                                .requestMatchers(HttpMethod.POST, "/api/flights", "/api/hotels", "/api/cars", "/api/packages").hasAuthority("ADMIN")
                                .requestMatchers(HttpMethod.PUT, "/api/flights/**", "/api/hotels/**", "/api/cars/**", "/api/packages/**").hasAuthority("ADMIN")
                                .requestMatchers(HttpMethod.DELETE, "/api/flights/**", "/api/hotels/**", "/api/cars/**", "/api/packages/**").hasAuthority("ADMIN")
                                .requestMatchers("/api/bookings/**").authenticated()
                                .anyRequest().permitAll()
                )
                .oauth2Login(oauth2Login ->
                        oauth2Login.defaultSuccessUrl("/", true)
                                .userInfoEndpoint(userInfo ->
                                        userInfo.userAuthoritiesMapper(userAuthoritiesMapper())
                                )
                );
        return http.build();
    }

    @Bean
    public GrantedAuthoritiesMapper userAuthoritiesMapper() {
        return (authorities) -> {
            Set<SimpleGrantedAuthority> mappedAuthorities = new HashSet<>();

            authorities.forEach(authority -> {
                if (authority instanceof OAuth2UserAuthority oauth2UserAuthority) {
                    String username = oauth2UserAuthority.getAttributes().get("login").toString();
                    // Replace "YOUR_GITHUB_USERNAME" with your actual GitHub username
                    if ("HimanshuNaik19".equalsIgnoreCase(username)) {
                        mappedAuthorities.add(new SimpleGrantedAuthority("ADMIN"));
                    }
                }
                mappedAuthorities.add(new SimpleGrantedAuthority("USER"));
            });

            return mappedAuthorities;
        };
    }
}
