package com.career.my.domain.dto

import java.util.UUID

class DailyLogResponse {
    data class Get(
        val id: UUID,
        val userId: UUID,
        val title: String,
        val content: String,
        val tags: List<String>
    )
}