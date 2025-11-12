package com.career.my.domain.dto

import java.util.UUID

class DailyLogCommand {
    data class Create(
        val userId: UUID,
        val title: String,
        val content: String,
        val tags: List<String> = mutableListOf()
    )
}