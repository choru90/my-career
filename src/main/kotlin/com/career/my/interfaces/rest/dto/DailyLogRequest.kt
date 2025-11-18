package com.career.my.interfaces.rest.dto

import java.util.UUID

// REST 계층에서만 사용하는 입력 DTO
class DailyLogRequest {
    data class Create(
        val userId: UUID,
        val title: String,
        val content: String,
        val tags: List<String>,
    )

    data class Get(
        val id: UUID,
    )
}
