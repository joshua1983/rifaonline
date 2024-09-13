package com.joshua.rifaback.repositories

import com.joshua.rifaback.data.UserLog
import org.springframework.data.repository.CrudRepository

interface LogRepository: CrudRepository<UserLog, Long> {
}