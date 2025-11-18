package com.career.my.application.dto

import java.util.UUID

// 유스케이스 실행 결과를 표현하는 모델
class DailyLogResult {
    data class Get(
        val id: UUID,
        val userId: UUID,
        val title: String,
        val content: String,
        val tags: List<String>
    )
}
