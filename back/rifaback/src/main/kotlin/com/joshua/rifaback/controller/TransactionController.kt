package com.joshua.rifaback.controller

import com.joshua.rifaback.data.Cell
import com.joshua.rifaback.data.SimplyCell
import com.joshua.rifaback.data.TransactionRequest
import com.joshua.rifaback.data.UserClient
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
      @RequestBody transaction: TransactionRequest
   ): ResponseEntity<Any?> {
      try {
         val transactionStatus = transactionService.recordNewTransaction(
            cell = transaction.cell,
            user = transaction.user
         )
         return ResponseEntity.ok().body(transactionStatus)
      } catch (ex: Exception) {
         return ResponseEntity.badRequest().body(ex.message)
      }
   }
}