package com.career.my.domain.model

import com.career.my.domain.model.common.BaseTimeEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import org.hibernate.annotations.JdbcTypeCode
import org.hibernate.type.SqlTypes
import java.util.UUID

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
) : BaseTimeEntity() {
    companion object {
        // 정적 팩토리 메서드로 도메인 객체를 일관되게 생성
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
