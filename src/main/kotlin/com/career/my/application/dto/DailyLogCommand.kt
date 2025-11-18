package com.career.my.application.dto

import java.util.UUID

// 유스케이스에서 사용하는 입력 명령 모델
class DailyLogCommand {
    data class Create(
        val userId: UUID,
        val title: String,
        val content: String,
        val tags: List<String> = mutableListOf()
    )

    data class Get(
        val id: UUID,
    )
}
