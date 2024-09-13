package com.joshua.rifaback.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.AuthenticationProvider
import org.springframework.security.authentication.dao.DaoAuthenticationProvider
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter

@Configuration
class SecurityConfig(
   private val jwtAuthenticationFilter: JwtAuthenticationFilter,
   private val userDetailsService: UserDetailsService
) {

   @Bean
   fun securityFilterChain(http: HttpSecurity): SecurityFilterChain {
      http
         .csrf { csrf -> csrf.disable() }
         .authorizeHttpRequests { authorizeRequests ->
            authorizeRequests
               .requestMatchers("/registro", "/login", "/board", "/transaction").permitAll()
               .anyRequest().authenticated()
         }
         .sessionManagement { it.sessionCreationPolicy(SessionCreationPolicy.STATELESS) }
         .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter::class.java)
         .authenticationProvider(authenticationProvider())
      return http.build()
   }

   @Bean
   fun authenticationProvider(): AuthenticationProvider {
      val authProvider = DaoAuthenticationProvider()
      authProvider.setUserDetailsService(userDetailsService)
      authProvider.setPasswordEncoder(passwordEncoder())
      return authProvider
   }

   @Bean
   fun authenticationManager(authConfig: AuthenticationConfiguration): AuthenticationManager {
      return authConfig.authenticationManager
   }

   @Bean
   fun passwordEncoder(): PasswordEncoder = BCryptPasswordEncoder()
}