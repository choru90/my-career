package com.career.my.domain

import com.career.my.common.BaseTimeEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import org.hibernate.annotations.JdbcTypeCode
import org.hibernate.type.SqlTypes
import java.util.*

@Table(name = "daily_logs")
@Entity
class DailyLog private constructor(
    @Id
    val id: UUID = UUID.randomUUID(),
    val userId: UUID,
    val title: String,
    val content: String,
    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition = "jsonb")
    val tags: List<String> = mutableListOf(),
): BaseTimeEntity() {
    companion object {
        fun of(userId: UUID, title: String, content: String, tags: List<String>): DailyLog {
            return DailyLog(
                userId = userId,
                title = title,
                content = content,
                tags = tags
            )
        }
    }

    protected constructor() : this(
        id = UUID.randomUUID(),
        userId = UUID.randomUUID(),
        title = "",
        content = "",
        tags = emptyList()
    )
}