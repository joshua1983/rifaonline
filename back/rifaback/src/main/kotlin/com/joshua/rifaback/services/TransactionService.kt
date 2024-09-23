package com.joshua.rifaback.services

import com.joshua.rifaback.data.Cell
import com.joshua.rifaback.data.CellStatus
import com.joshua.rifaback.data.SimplyCell
import com.joshua.rifaback.data.Transaction
import com.joshua.rifaback.data.TransactionStatus
import com.joshua.rifaback.data.UserClient
import com.joshua.rifaback.repositories.TransactionRepository
import org.springframework.stereotype.Service
import java.time.Instant

@Service
class TransactionService(
   val transactionRepository: TransactionRepository,
   val cellService: CellService
) {
   fun recordNewTransaction(cell: SimplyCell, user: UserClient): TransactionStatus{
      val cellFound = cellService.getCell(cell.id)
      updateCellStatus(cellFound)
      val transaction = Transaction(
         cell = cellFound,
         date = Instant.now(),
         name = user.name,
         address = user.address,
         phone = user.phone
      )
      val savedTransaction = transactionRepository.save(transaction)
      return savedTransaction.status

   }

   fun updateCellStatus(cell: Cell){
      val updatedCell = Cell(
         id = cell.id,
         status = CellStatus.PAID,
         numberCell = cell.numberCell,
         user = cell.user,
         board = cell.board
      )
      cellService.saveCell(updatedCell)
   }

}