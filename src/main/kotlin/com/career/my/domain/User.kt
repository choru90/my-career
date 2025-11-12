package com.career.my.domain

import com.career.my.common.BaseTimeEntity
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.util.*

@Entity
@Table(name = "users")
class User(
    @Id
    val id: UUID,
    val email: String,
    val password: String,
    val name: String,
    ): BaseTimeEntity() {
}