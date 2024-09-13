package com.joshua.rifaback.repositories

import com.joshua.rifaback.data.Transaction
import org.springframework.data.repository.CrudRepository

interface TransactionRepository: CrudRepository<Transaction, Long>