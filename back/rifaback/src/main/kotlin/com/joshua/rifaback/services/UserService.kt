package com.joshua.rifaback.services

import com.joshua.rifaback.data.User
import com.joshua.rifaback.data.UserData
import com.joshua.rifaback.exceptions.UserCreationException
import com.joshua.rifaback.exceptions.NotFoundException
import com.joshua.rifaback.repositories.UserRepository
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class UserService(
   val userRepository: UserRepository,
   private val passwordEncoder: PasswordEncoder
) {

   fun getUserByEmail(email: String): UserData? {
      val user = userRepository.findUserByEmail(email)
      if (user != null) {
         return UserData(
            id = user.id,
            email = user.email,
            name = user.name,
            phone = user.phone,
            address = user.address,
            role = user.role,
            status = user.status
         )
      } else {
         throw NotFoundException("User not found")
      }
   }

   fun createUser(user: User): UserData {
      val findUser = userRepository.findUserByEmail(user.email)
      if (findUser != null) {
         throw UserCreationException("User already exists")
      } else {
         val newUser = User(
            email = user.email,
            name = user.name,
            password = passwordEncoder.encode(user.password),
            phone = user.phone,
            address = user.address
         )
         userRepository.save(newUser)
         return UserData(
            id = newUser.id,
            email = newUser.email,
            name = newUser.name,
            phone = newUser.phone,
            address = newUser.address,
            role = newUser.role,
            status = newUser.status
         )
      }
   }
}