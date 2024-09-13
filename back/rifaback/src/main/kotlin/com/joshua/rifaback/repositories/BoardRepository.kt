package com.joshua.rifaback.repositories

import com.joshua.rifaback.data.Board
import com.joshua.rifaback.data.Cell
import com.joshua.rifaback.data.User
import com.joshua.rifaback.data.UserBoard
import org.springframework.data.repository.CrudRepository

interface BoardRepository: CrudRepository<Board, Int> {
}

interface BoardCellRepository: CrudRepository<Cell, Int> {
   fun findAllByBoardId(boardId: Long): List<Cell>
}

interface UserBoardRepository : CrudRepository<UserBoard, Int> {
   fun findAllByUser(user: User): List<UserBoard>
}
