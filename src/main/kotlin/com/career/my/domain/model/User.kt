package com.career.my.domain.model

import com.career.my.domain.model.common.BaseTimeEntity
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.util.UUID

@Entity
@Table(name = "users")
class User(
    @Id
    val id: UUID,
    val email: String,
    val password: String,
    val name: String,
) : BaseTimeEntity()
