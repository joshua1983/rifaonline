package com.joshua.rifaback.services.security

import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.core.env.Environment
import org.springframework.security.core.Authentication
import org.springframework.stereotype.Service
import java.util.Date
import io.jsonwebtoken.security.Keys
import javax.crypto.SecretKey

@Service
class JwtTokenProvider(
   private val environment: Environment
) {


   private val secretKey: SecretKey = Keys.secretKeyFor(SignatureAlgorithm.HS512)
   private val expirationInMs: Long = 3600000
   fun generateToken(authentication: Authentication): String {
      val userName = authentication.name
      val now = Date()
      val expirationDate = Date(now.time + expirationInMs)

      return Jwts.builder()
         .setSubject(userName)
         .claim("roles", authentication.authorities)
         .setIssuedAt(Date())
         .setExpiration(expirationDate)
         .signWith(secretKey)
         .compact()

   }

   fun getUsernameFromJWT(token: String): String {
      val claims = Jwts.parser()
         .setSigningKey(secretKey)
         .parseClaimsJws(token)
         .body

      return claims.subject
   }

   fun validateToken(authToken: String): Boolean {
      return try {
         Jwts.parser()
            .setSigningKey(secretKey)
            .parseClaimsJws(authToken)
         true
      } catch (ex: Exception) {
         false
      }
   }
}