package com.krillinator.lektion_5.__database_response_entity.repository

import com.krillinator.lektion_5.__database_response_entity.model.CustomUser
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository // Mark as repository, for component scanning in Spring
interface CustomUserRepository: JpaRepository<CustomUser, Long> {

    /*
    @Query("""
        SELECT
        FROM
        WHERE
    """)
    fun test()

     */

}