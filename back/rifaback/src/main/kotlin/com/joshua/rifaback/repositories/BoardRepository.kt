package com.joshua.rifaback.repositories

import com.joshua.rifaback.data.Board
import com.joshua.rifaback.data.Cell
import com.joshua.rifaback.data.User
import org.springframework.data.repository.CrudRepository

interface BoardRepository: CrudRepository<Board, Int> {
   fun findAllByUser(user: User): List<Board>
}

interface BoardCellRepository: CrudRepository<Cell, Int> {
   fun findAllByBoardId(boardId: Long): List<Cell>
   fun findCellById(id: Long): Cell?
}

interface UserCellRepository : CrudRepository<Cell, Int> {
   fun findAllByUser(user: User): List<Cell>
}
