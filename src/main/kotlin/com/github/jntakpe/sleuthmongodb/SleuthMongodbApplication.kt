package com.github.jntakpe.sleuthmongodb

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.*

@SpringBootApplication
class SleuthMongodbApplication {

    @RestController
    @RequestMapping("/users")
    class UserResource(private val userRepository: UserRepository) {

        @PostMapping
        fun create(@RequestBody user: User) = userRepository.save(user)

        @GetMapping
        fun findAll() = userRepository.findAll()
    }

}

fun main(args: Array<String>) {
    runApplication<SleuthMongodbApplication>(*args)
}
