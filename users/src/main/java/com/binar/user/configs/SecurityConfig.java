package com.binar.user.configs;

import com.binar.user.security.AuthEntryJWT;
import com.binar.user.security.AuthTokenFilter;
import com.binar.user.services.UserDetailServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig {

    private static final String ADMIN = "ADMIN";
    private static final String CUSTOMER = "CUSTOMER";



    @Bean
    public AuthTokenFilter authenticationJwtTokenFilter() {
        return new AuthTokenFilter();
    }


    @Bean
    public DaoAuthenticationProvider authenticationProvider(UserDetailServiceImpl userDetailsService) {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();

        authProvider.setUserDetailsService(userDetailsService);
        authProvider.setPasswordEncoder(passwordEncoder());

        return authProvider;
    }


    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
        return authConfig.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http, AuthEntryJWT unauthorizedHandler, UserDetailServiceImpl userDetailsService) throws Exception {
        http.cors().and().csrf().disable();
        http.exceptionHandling().authenticationEntryPoint(unauthorizedHandler);
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and();
        http.authorizeRequests()
                //No Auth
                .antMatchers("/user/signup").permitAll()
                .antMatchers("/user/login").permitAll()
                .antMatchers("/schedule/**").permitAll()
                .antMatchers("/film/get/**").permitAll()
                .antMatchers("/notification/**").permitAll()
                //Customer
                .antMatchers("/invoice/**").hasAnyAuthority(CUSTOMER)
                .antMatchers("/user/get/**").hasAnyAuthority(CUSTOMER,ADMIN)
                .antMatchers("/user/update").hasAnyAuthority(CUSTOMER)
                .antMatchers("/user/delete/**").hasAnyAuthority(CUSTOMER)


                //Admin
                .antMatchers("/film/create").hasAnyAuthority(ADMIN)
                .antMatchers("/film/update").hasAnyAuthority(ADMIN)
                .antMatchers("/film/delete/**").hasAnyAuthority(ADMIN);


        http.authenticationProvider(authenticationProvider(userDetailsService));

        http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

}
