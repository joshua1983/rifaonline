package com.joshua.rifaback.core

import com.joshua.rifaback.data.Board
import com.joshua.rifaback.data.BoardCell
import com.joshua.rifaback.data.BoardStatus
import com.joshua.rifaback.data.Cell
import com.joshua.rifaback.data.User
import com.joshua.rifaback.data.UserBoard
import com.joshua.rifaback.data.UserData
import com.joshua.rifaback.exceptions.NotFoundException
import com.joshua.rifaback.repositories.UserBoardRepository
import com.joshua.rifaback.repositories.UserRepository
import com.joshua.rifaback.services.BoardService
import com.joshua.rifaback.services.CellService
import org.springframework.stereotype.Service

@Service
class BoardFactory(
   val cellService: CellService,
   val userRepository: UserRepository,
   val userBoardRepository: UserBoardRepository,
   val boardService: BoardService
) {


   fun getBoardFromUser(userEmail: String): Board {
      val userFound = userRepository.findUserByEmail(userEmail)
      if (userFound != null) {
         val boards = userBoardRepository.findAllByUser(userFound)
         if (boards.isEmpty()) {
            throw NotFoundException("No boards found")
         } else {
            return boards.first { it.board.status == BoardStatus.OPEN }.board
         }
      } else {
         throw NotFoundException("No User found")
      }
   }

   fun getBoard(email: String): BoardCell {
      val board = getBoardFromUser(email)
      val cells = cellService.getAllCells(board)
      return BoardCell(board, cells)
   }

   fun createNewBoard(board: Board, user: UserData): BoardCell {
      val foundUser = userRepository.findUserByEmail(user.email) ?: throw NotFoundException("User not found")
      val savedBoard = boardService.createBoard(board)
      return createNewBoardCells(savedBoard, foundUser)
   }

   /*
   Board y User deben existir en base de datos
    */
   private fun createNewBoardCells(board: Board, user: User): BoardCell {
      val userBoard = UserBoard(user=user, board=board)
      userBoardRepository.save(userBoard)
      val cells = ArrayList<Cell>()
      val size = board.size * board.size
      for (i in 1 .. size){
         val cell = Cell(
            board = board,
            numberCell = i
         )
         cells.add(cell)
         cellService.saveCell(cell)
      }
      return BoardCell(board, cells)
   }
}