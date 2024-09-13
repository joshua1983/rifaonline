package com.joshua.rifaback.services

import com.joshua.rifaback.data.Cell
import com.joshua.rifaback.data.Transaction
import com.joshua.rifaback.data.TransactionStatus
import com.joshua.rifaback.data.User
import com.joshua.rifaback.data.UserData
import com.joshua.rifaback.repositories.TransactionRepository
import com.joshua.rifaback.repositories.UserRepository
import org.springframework.stereotype.Service
import java.time.Instant

@Service
class TransactionService(
   val transactionRepository: TransactionRepository,
   val userService: UserService
) {
   fun recordNewTransaction(cell: Cell, user: User): TransactionStatus{
      var userFound = userService.getUserByEmail(user.email)
      if (userFound == null){
         userFound = userService.createUser(user)
      }
      val transaction = Transaction(
         cell = cell,
         date = Instant.now(),
         user = userFound.toUserOfuscated()
      )
      val savedTransaction = transactionRepository.save(transaction)
      return savedTransaction.status

   }

}