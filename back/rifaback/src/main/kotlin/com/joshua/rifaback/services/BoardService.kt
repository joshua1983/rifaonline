package com.joshua.rifaback.services;


import com.joshua.rifaback.data.Board
import com.joshua.rifaback.repositories.BoardRepository
import org.springframework.stereotype.Service

@Service
class BoardService(
   val boardRepository: BoardRepository
) {

   fun createBoard(board: Board): Board {
      return boardRepository.save(board)
   }
}
