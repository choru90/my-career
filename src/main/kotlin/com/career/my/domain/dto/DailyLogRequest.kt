package com.career.my.domain.dto

import java.util.*

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