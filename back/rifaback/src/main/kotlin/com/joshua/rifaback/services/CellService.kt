package com.joshua.rifaback.services

import com.joshua.rifaback.data.Board
import com.joshua.rifaback.data.BoardCell
import com.joshua.rifaback.data.Cell
import com.joshua.rifaback.repositories.BoardCellRepository
import org.springframework.stereotype.Service

@Service
class CellService (val boardCellRepository: BoardCellRepository) {
   fun getAllCells(board: Board): List<Cell> {
      return boardCellRepository.findAllByBoardId(board.id)
   }

   fun saveCell(cell: Cell): Cell {
      return boardCellRepository.save(cell)
   }
}