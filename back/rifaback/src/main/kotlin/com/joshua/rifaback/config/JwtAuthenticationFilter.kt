package com.joshua.rifaback.config

import com.joshua.rifaback.services.security.JwtTokenProvider
import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter

@Component
class JwtAuthenticationFilter(
   private val tokenProvider: JwtTokenProvider,
   private val userDetailsService: UserDetailsService
): OncePerRequestFilter() {
   override fun doFilterInternal(request: HttpServletRequest, response: HttpServletResponse, filterChain: FilterChain) {
      val token = getJwtFromRequest(request)

      if (!token.isNullOrEmpty() && tokenProvider.validateToken(token)) {
         val userName = tokenProvider.getUsernameFromJWT(token)
         val userDetails = userDetailsService.loadUserByUsername(userName)
         val authentication = UsernamePasswordAuthenticationToken(userDetails, null, userDetails.authorities)
         authentication.details = WebAuthenticationDetailsSource().buildDetails(request)
         SecurityContextHolder.getContext().authentication = authentication
      }
      filterChain.doFilter(request, response)
   }

   private fun getJwtFromRequest(request: HttpServletRequest): String? {
      val bearerToken = request.getHeader("Authorization")
      return if (!bearerToken.isNullOrEmpty() && bearerToken.startsWith("Bearer")){
         bearerToken.substring(7)
      } else null
   }
}