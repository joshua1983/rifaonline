package com.joshua.rifaback.services

import com.joshua.rifaback.data.Board
import com.joshua.rifaback.data.Cell
import com.joshua.rifaback.exceptions.QueryException
import com.joshua.rifaback.repositories.BoardCellRepository
import org.springframework.stereotype.Service

@Service
class CellService (val boardCellRepository: BoardCellRepository
) {
   fun getAllCells(board: Board): List<Cell> {
      return boardCellRepository.findAllByBoardId(board.id)
   }

   fun getCell(cellId: Long): Cell {
      return boardCellRepository.findCellById(cellId) ?: throw QueryException("Cell with id $cellId does not exist")
   }

   fun saveCell(cell: Cell): Cell {
      return boardCellRepository.save(cell)
   }

}