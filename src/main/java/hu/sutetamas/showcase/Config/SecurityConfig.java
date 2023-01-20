package hu.sutetamas.showcase.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig{
    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeHttpRequests()
                    .requestMatchers(HttpMethod.GET, "/api/**").hasAnyRole("ADMIN", "USER")
                    .requestMatchers(HttpMethod.POST, "/api/**").hasRole("ADMIN")
                    .requestMatchers(HttpMethod.PUT, "/api/**").hasRole("ADMIN")
                .and()
                .httpBasic()
                .and()
                .formLogin().permitAll()
                .and()
                .logout().permitAll();

        return http.build();
    }
}