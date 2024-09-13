package com.joshua.rifaback.controller

import com.joshua.rifaback.data.Cell
import com.joshua.rifaback.data.User
import com.joshua.rifaback.services.TransactionService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
@CrossOrigin(origins = ["*"])
class TransactionController(
   val transactionService: TransactionService
) {

   @PostMapping("/transaction")
   fun createNewTransaction(
      @RequestBody cell: Cell,
      @RequestBody user: User
   ): ResponseEntity<Any?> {
      try {
         val transactionStatus = transactionService.recordNewTransaction(
            cell = cell,
            user = user
         )
         return ResponseEntity.ok().body(transactionStatus)
      } catch (ex: Exception) {
         return ResponseEntity.badRequest().body(ex.message)
      }
   }
}