package com.joshua.rifaback

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootApplication
@EnableJpaRepositories
@EntityScan(basePackages = ["com.joshua.rifaback"])
class RifabackApplication

fun main(args: Array<String>) {
   runApplication<RifabackApplication>(*args)
}
