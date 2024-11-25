package com.krillinator.lektion_5.__database_response_entity.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

// Entity = Object to be persisted in DB
/* Rules to be applied to Entity
*
*  #1 @Entity Annotation
*  #2 No Args Constructor
*  #3 No Final Values
*  #4 No public variables
* */

// What is a constructor?
// A: Definition of values during instantiation of object

// What is Instantiation?
// val test = CustomUser() <-- Is instantiation of object

// No additional work needed:
// Explanation: default values handle the no-args case
// NOW: We have NO args & ALL args
@Entity
@Table(name = "CustomUser")   // Override Table Name (Not a Requirement) TableName by default = CustomUser
class CustomUser(
    val username: String = "",
    val password: String = "",
    val isEnabled: Boolean = true,

    // PK (Primary Key)
    // GeneratedValue = How do we generate our Primary key? (Auto = Automatically)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long? = null,
) {



}