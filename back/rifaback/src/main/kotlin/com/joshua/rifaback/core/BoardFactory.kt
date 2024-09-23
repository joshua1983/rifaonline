package com.joshua.rifaback.core

import com.joshua.rifaback.data.Board
import com.joshua.rifaback.data.BoardCell
import com.joshua.rifaback.data.BoardRequest
import com.joshua.rifaback.data.Cell
import com.joshua.rifaback.data.DataBoardCells
import com.joshua.rifaback.data.SimplyCell
import com.joshua.rifaback.data.UserData
import com.joshua.rifaback.exceptions.NotFoundException
import com.joshua.rifaback.repositories.UserCellRepository
import com.joshua.rifaback.repositories.UserRepository
import com.joshua.rifaback.services.BoardService
import com.joshua.rifaback.services.CellService
import org.springframework.stereotype.Service

@Service
class BoardFactory(
   val cellService: CellService,
   val userRepository: UserRepository,
   val userBoardRepository: UserCellRepository,
   val boardService: BoardService
) {


   fun getBoardsFromUser(userEmail: String): List<Board> {
      val userFound = userRepository.findUserByEmail(userEmail)
      if (userFound != null) {
         return boardService.getBoardFromUser(userFound)
      } else {
         throw NotFoundException("No User found")
      }
   }

   fun getCellsFromBoard(boardId: Long): List<DataBoardCells> {
      return emptyList()
   }

   fun getBoard(id: Int): BoardCell {
      val board = boardService.getBoard(id)
      val cells = cellService.getAllCells(board)
      return BoardCell(board.toBoardResponse(), simplifyCells(cells))
   }

   fun simplifyCells(cells: List<Cell>): List<SimplyCell>{
      val simplyCells = mutableListOf<SimplyCell>()
      cells.forEach { cell ->
         simplyCells.add(SimplyCell(
            id = cell.id,
            numberCell = cell.numberCell,
            status = cell.status
         ))
      }
      return simplyCells
   }

   fun createNewBoard(board: BoardRequest, user: UserData): BoardCell {
      val foundUser = userRepository.findUserByEmail(user.email) ?: throw NotFoundException("User not found")
      val savedBoard = boardService.createBoard(board, foundUser)
      return createNewBoardCells(savedBoard)
   }

   /*
   Board y User deben existir en base de datos
    */
   private fun createNewBoardCells(board: Board): BoardCell {
      val cells = ArrayList<Cell>()
      for (i in 1..100) {
         val cell = Cell(
            board = board,
            numberCell = i,
            user = null,
         )
         cells.add(cell)
         cellService.saveCell(cell)
      }
      return BoardCell(board.toBoardResponse(), simplifyCells(cells))
   }
}