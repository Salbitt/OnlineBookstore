package com.example.user_service.config;

import com.example.user_service.service.impl.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Autowired
    private CustomUserDetailsService userDetailsService;


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((requests)->
                        requests.requestMatchers("http://localhost:8091/api/users/admin/**").hasRole("ADMIN")
                                .anyRequest().authenticated()).
                formLogin((form)->
                        form.loginPage("/login").permitAll())
                .logout(LogoutConfigurer::permitAll);

        return http.build();


//                .requestMatchers("/admin/**").hasRole("ADMIN")
//                .anyRequest().authenticated())
//                .formLogin()
//                .permitAll()
//                .and()
//                .logout()
//                .permitAll();
//        http
//                .authorizeHttpRequests((requests) -> requests
//                        .requestMatchers("/", "/home").permitAll()
//                        .requestMatchers("/admin-only").hasRole("ADMIN")
//                        .anyRequest().authenticated()
//                )
//                .formLogin((form) -> form
//                        .loginPage("/login")
//                        .permitAll()
//                )
//                .logout(LogoutConfigurer::permitAll);

    }


    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
