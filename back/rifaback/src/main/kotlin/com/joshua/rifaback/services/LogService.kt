package com.joshua.rifaback.services

import com.joshua.rifaback.data.UserLog
import com.joshua.rifaback.repositories.LogRepository
import org.springframework.stereotype.Service
import java.time.Instant

@Service
class LogService(val logRepository: LogRepository) {

   fun recordLog(message: String) {
      logRepository.save(UserLog(message = message, date = Instant.now()))
   }
}