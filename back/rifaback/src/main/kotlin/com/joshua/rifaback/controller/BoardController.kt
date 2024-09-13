package com.joshua.rifaback.controller

import com.joshua.rifaback.core.BoardFactory
import com.joshua.rifaback.data.Board
import com.joshua.rifaback.data.NewBoard
import com.joshua.rifaback.data.User
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@CrossOrigin(origins = ["*"])
class BoardController (
   val boardFactory: BoardFactory
) {

   @GetMapping("/board")
   fun getBoardFromUserEmail(@RequestParam(value = "email", required = true) email: String): ResponseEntity<Any> {
      try {
         val board = boardFactory.getBoard(email)
         return ResponseEntity.status(HttpStatus.OK).body(board)
      } catch (ex: Exception) {
         return ResponseEntity.badRequest().body(ex.message!!)
      }
   }

   @PostMapping("/board")
   @PreAuthorize("hasRole('ADMIN')")
   fun createNewBoard(
      @RequestBody requestBoard: NewBoard): ResponseEntity<Any> {
      try {
         val board = requestBoard.board
         val user = requestBoard.user
         val boardCell = boardFactory.createNewBoard(board, user)
         return ResponseEntity.status(HttpStatus.CREATED).body(boardCell)
      } catch (ex: Exception) {
         return ResponseEntity.badRequest().body(ex.message!!)
      }
   }
}