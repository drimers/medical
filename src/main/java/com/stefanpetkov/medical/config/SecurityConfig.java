package com.stefanpetkov.medical.config;


import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.event.AuthenticationFailureBadCredentialsEvent;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

//TODO: form login
@Configuration
@EnableWebSecurity
public class SecurityConfig {


    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
                .authorizeHttpRequests(authConfig -> {
                    authConfig.requestMatchers(HttpMethod.GET, "/", "/home", "/login", "/logon", "/register", "/display_form", "/save", "/contact", "/error/**", "/login-error", "/logout", "/css/**",
                            "/fonts/**", "/assets/**", "/img/**", "/js/**", "/vendor/**", "/common/**", "/h2-console/**").permitAll();
                    authConfig.requestMatchers(HttpMethod.GET, "/patient").hasRole("PATIENT");
                    authConfig.requestMatchers(HttpMethod.GET, "/doctor").hasRole("DOCTOR");
//                    authConfig.requestMatchers(HttpMethod.GET, "/admin").hasRole("ADMIN");
//                    authConfig.requestMatchers(HttpMethod.GET, "/users").hasAnyRole("DEVELOPER");
//                    authConfig.requestMatchers(HttpMethod.GET, "/authorities").hasAnyRole("DEVELOPER");
                    authConfig.anyRequest().authenticated();
                })
                .formLogin(login -> {
                            login.loginPage("/login");
                            login.defaultSuccessUrl("/home");
                            login.failureUrl("/error/403error");
                        }
                )
                .logout(logout -> {
                    logout.logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
                    logout.logoutSuccessUrl("/home");
                    logout.deleteCookies("JSESSIONID");
                    logout.invalidateHttpSession(true);
                });
        return http.build();
    }


    // Only for testing without security
//    @Bean
//    public WebSecurityCustomizer webSecurityCustomizer() {
//        return (web) -> web.ignoring().anyRequest();
//    }

//        @Bean
//        UserDetailsService myUserDetailsService(CredentialsRepository credentialsRepository) {
//        return new MyUserDetailsService(credentialsRepository);
//    }


//    @Bean
//    UserDetailsService myUserDetailsService(UserRepository userRepository) {
//        return new MyUserDetailsService(userRepository);
//    }
//
//    @Bean
//    BCryptPasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    @Bean
//    SecurityEvaluationContextExtension securityEvaluationContextExtension() {
//        return new SecurityEvaluationContextExtension();
//    }

    @Bean
    ApplicationListener<AuthenticationSuccessEvent> successEvent() {
        return event -> {
            System.out.println("Success Login " + event.getAuthentication().getClass().getSimpleName() + " - " + event.getAuthentication().getName());
        };
    }

    @Bean
    ApplicationListener<AuthenticationFailureBadCredentialsEvent> failureEvent() {
        return event -> {
            System.err.println("Bad Credentials Login " + event.getAuthentication().getClass().getSimpleName() + " - " + event.getAuthentication().getName());
        };
    }

}
