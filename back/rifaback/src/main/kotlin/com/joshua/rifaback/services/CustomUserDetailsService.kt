package com.joshua.rifaback.services

import com.joshua.rifaback.repositories.UserRepository
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class CustomUserDetailsService(
   private val userRepository: UserRepository
): UserDetailsService {

   @Transactional(readOnly = true)
   @Throws(UsernameNotFoundException::class)
   override fun loadUserByUsername(username: String?): UserDetails {
      val user = userRepository.findUserByEmail(username)
      ?: throw UsernameNotFoundException("User $username not found")

      val authorities = SimpleGrantedAuthority(user.role)
      return org.springframework.security.core.userdetails.User
         .withUsername(username)
         .password(user.password)
         .authorities(authorities).build()
   }
}