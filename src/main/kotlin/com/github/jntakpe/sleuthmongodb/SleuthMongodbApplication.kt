package com.github.jntakpe.sleuthmongodb

import org.bson.types.ObjectId
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.web.bind.annotation.*
import java.io.Serializable

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

    //If you remove the indexed annotation it will work fine
    @Document
    data class User(@Indexed val username: String, val id: ObjectId? = null): Serializable
}

fun main(args: Array<String>) {
    runApplication<SleuthMongodbApplication>(*args)
}
