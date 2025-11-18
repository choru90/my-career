package com.career.my.interfaces.rest.dto

import java.util.UUID

// REST 응답 전용 DTO
class DailyLogResponse {
    data class Get(
        val id: UUID,
        val userId: UUID,
        val title: String,
        val content: String,
        val tags: List<String>
    )
}
