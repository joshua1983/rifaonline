package com.joshua.rifaback.repositories

import com.joshua.rifaback.data.User
import org.springframework.data.repository.CrudRepository

interface UserRepository: CrudRepository<User, Long>   {
   fun findUserByEmail(email: String?): User?
   fun findUserByEmailAndPassword(email: String, password: String): User?
}
