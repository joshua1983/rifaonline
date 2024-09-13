package com.joshua.rifaback.controller

import com.joshua.rifaback.data.JwtAuthenticationResponse
import com.joshua.rifaback.data.LoginRequest
import com.joshua.rifaback.data.User
import com.joshua.rifaback.services.UserService
import com.joshua.rifaback.services.security.JwtTokenProvider
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@CrossOrigin(origins = ["*"])
class UserController(
   val userService: UserService,
   private val tokenProvider: JwtTokenProvider,
   private val authenticationManager: AuthenticationManager
) {

   @PostMapping("/login")
   fun authUser(@RequestBody loginRequest: LoginRequest): ResponseEntity<JwtAuthenticationResponse> {
      val authentication = authenticationManager.authenticate(
         UsernamePasswordAuthenticationToken(
            loginRequest.username,
            loginRequest.password
         )
      )
      SecurityContextHolder.getContext().authentication = authentication
      val token = tokenProvider.generateToken(authentication)
      return ResponseEntity.ok(JwtAuthenticationResponse(token))
   }

   @GetMapping("/user")
   @PreAuthorize("hasRole('USER')")
   fun getUser(@RequestParam email: String): ResponseEntity<Any> {
      try{
         val user = userService.getUserByEmail(email)
         return ResponseEntity
            .status(HttpStatus.OK)
            .body(user)
      } catch (ex: Exception) {
         return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
            .body(ex.message)
      }
   }

   @PostMapping("/registro")
   fun saveUser(@RequestBody user: User): ResponseEntity<Any> {
      try {
         val newUser = userService.createUser(user)
         return ResponseEntity
            .status(HttpStatus.OK)
            .body(newUser)
      } catch (ex: Exception) {
         return ResponseEntity
            .status(HttpStatus.INTERNAL_SERVER_ERROR)
            .body(ex.message)
      }
   }
}