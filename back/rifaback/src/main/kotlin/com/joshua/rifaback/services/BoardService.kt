package com.joshua.rifaback.services;


import com.joshua.rifaback.data.Board
import com.joshua.rifaback.data.BoardRequest
import com.joshua.rifaback.data.User
import com.joshua.rifaback.exceptions.QueryException
import com.joshua.rifaback.repositories.BoardRepository
import org.springframework.stereotype.Service

@Service
class BoardService(
   val boardRepository: BoardRepository
) {

   fun getBoardFromUser(user: User): List<Board> {
      return boardRepository.findAllByUser(user)
   }

   fun getBoard(id: Int): Board{
      val boardFound = boardRepository.findById(id)
      if (boardFound.isPresent){
         return boardFound.get()
      } else {
         throw QueryException("Board not found with id $id")
      }
   }

   fun createBoard(board: BoardRequest, user: User): Board {
      val newBoard = Board(
         size = board.size,
         title = board.title,
         description = board.description,
         rules = board.rules,
         user = user
      )
      return boardRepository.save(newBoard)
   }
}
