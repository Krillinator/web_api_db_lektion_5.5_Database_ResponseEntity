package com.krillinator.lektion_5.__database_response_entity.controller

import com.krillinator.lektion_5.__database_response_entity.model.CustomUser
import com.krillinator.lektion_5.__database_response_entity.repository.CustomUserRepository
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.*

/* Best Practices - RestController
* Do NOT return - simple objects
* Always return - Response Entity
* */

// ResponseEntity
/* Includes the following:
* Header
* Body
* Status Code
* */

@RestController
@RequestMapping("/user")
class CustomUserController(
    private val customUserRepository: CustomUserRepository // Dependency Injection through Autowired
) {

    @GetMapping
    fun getUserByUserId(@RequestParam("id") id: Long): ResponseEntity<CustomUser> {

        // This user is Optional
        val foundOptionalUser = customUserRepository.findById(id)

        // Does the value exist, is it NOT NULL?
        // isPresent ONLY exists in optionals, to type-check
        if (foundOptionalUser.isPresent) {
            val notOptionalUser = foundOptionalUser.get() // .get() REMOVES optional

            return ResponseEntity.status(200).body(notOptionalUser)
        }

        return ResponseEntity.notFound().build()
    }

    @PostMapping
    fun postNewUser(@RequestBody customUser: CustomUser): ResponseEntity<String> {

        customUserRepository.save(customUser)

        return ResponseEntity.status(201).body("User Created")
    }

    @PutMapping
    fun putUser(): ResponseEntity<String> {

        // TODO - In order to get this to work, you need:
        // TODO - #1 - Find User By Id
        // TODO - #2 - If user exists, use .save() with new values
        // TODO - #3 - If user doesn't exist, ResponseEntity.notFound().build()

        return ResponseEntity.status(201).body("User Created")
    }

    // TODO - PUT & DELETE

    // TODO - Why increment with +50

}