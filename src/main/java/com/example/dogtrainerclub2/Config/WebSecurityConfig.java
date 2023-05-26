package com.example.dogtrainerclub2.Config;

import com.example.dogtrainerclub2.Security.AuthEntryPointJwt;
import com.example.dogtrainerclub2.Security.AuthTokenFilter;
import com.example.dogtrainerclub2.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;




@EnableWebSecurity
//@SuppressWarnings("deprecation")
@Configuration
@EnableMethodSecurity
    public class WebSecurityConfig {

  @Autowired
  UserDetailsServiceImpl userDetailsService;

  @Autowired
  private AuthEntryPointJwt unauthorizedHandler;

  @Bean
  public AuthTokenFilter authenticationJwtTokenFilter() {
    return new AuthTokenFilter();
  }

  @Bean
  public DaoAuthenticationProvider authenticationProvider() {
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
  public SecurityFilterChain configure(HttpSecurity http) throws Exception {
    http.cors().and().csrf().disable()
        .exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
        .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
        .authorizeHttpRequests()
        //Signin/signup
        .requestMatchers("/api/auth/signup", "/api/auth/signin").permitAll()
        //posts
        .requestMatchers("/upload", "/post", "/About", "/image","/image/info/{name}","/image/{name}", "/Selection", "/prove").permitAll()
        //get
        .requestMatchers("/files" ,"/posts", "/Selection/info/{name}","/Selection/{id}", "/prover", "image", "/image/info/{name}","/image/{name}").permitAll()
        //users
        .requestMatchers("/api/test/all").permitAll()
        .requestMatchers("/api/test/user").hasAnyRole("USER","MODERATOR", "ADMIN")
        .requestMatchers("/api/test/mod").hasRole("MODERATOR")
        .requestMatchers("/api/test/admin").hasRole("ADMIN")

        .anyRequest().authenticated();

    http.authenticationProvider(authenticationProvider());

    http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);

    return http.build();
  }



   }





