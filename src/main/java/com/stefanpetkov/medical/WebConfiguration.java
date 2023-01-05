package com.stefanpetkov.medical;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class WebConfiguration extends WebSecurityConfigurerAdapter {




        @Override
        protected void configure(HttpSecurity httpSecurity) throws Exception {
            httpSecurity.authorizeRequests().antMatchers("/home/**").permitAll().and()
                    .formLogin() .loginPage("/login").permitAll().and()
                    .authorizeRequests().antMatchers("/h2-console/**").permitAll();
            httpSecurity.csrf().disable();
            httpSecurity.headers().frameOptions().disable();
        }





//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .csrf().disable()
//                .authorizeRequests().antMatchers("/home**")
//                .permitAll() .anyRequest().authenticated()
//                .and()
//                .formLogin() .loginPage("/login")
//                .permitAll()
//                .and()
//                .logout() .invalidateHttpSession(true)
//                .clearAuthentication(true) .permitAll();
//    }

//    @Override
//    protected void configure(final HttpSecurity http) throws Exception {
//
//
//
//        //@formatter:off
//        http.authorizeRequests()
//                .antMatchers("/login").permitAll()
//                .antMatchers("/**").hasAnyRole( "PATIENT","ADMIN")
//                .antMatchers("/admin/**").hasAnyRole("ADMIN")
//                .and()
//                .formLogin()
//                .loginPage("/login")
//                .loginProcessingUrl("/logon")
//                .defaultSuccessUrl("/home")
//                .failureUrl("/login?error=true")
//                .permitAll()
//                .and()
//                .logout()
//                .logoutSuccessUrl("/login?logout=true")
//                .invalidateHttpSession(true)
//                .deleteCookies("JSESSIONID")
//                .permitAll()
//                .and()
//                .csrf()
//                .disable();
//        //@formatter:on
//    }

//    @Override
//    public void configure(WebSecurity web) {
//        web.ignoring()
//                .antMatchers("/home/**", "/h2-console/**");
//    }


//    public SecurityFilterChain filterChain(HttpSecurity http) {
//        http
//                .formLogin(form -> form
//                        .loginPage("/login")
//                        .permitAll()
//                );
//        // ...
//    }

}

