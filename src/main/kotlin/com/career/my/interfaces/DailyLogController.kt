package com.career.my.interfaces

import com.career.my.domain.dto.DailyLogCommand
import com.career.my.domain.dto.DailyLogRequest
import com.career.my.domain.service.DailyLogService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import jakarta.validation.Valid

@Tag(name = "DailyLog", description = "데일리 로그 API")
@RestController
@RequestMapping("/daily-logs")
@Validated
class DailyLogController(
    private val service: DailyLogService
) {

    @Operation(
        summary = "데일리 로그 생성",
        description = "userId, title, content, tags로 데일리 로그를 생성합니다."
    )
    @ApiResponse(
        responseCode = "200",
        description = "생성 완료",
        content = [Content(schema = Schema(implementation = String::class))]
    )
    @PostMapping
    fun create(@Valid @RequestBody req: DailyLogRequest.Create): String {
        service.create(
            DailyLogCommand.Create(
                userId = req.userId,
                title = req.title,
                content = req.content,
                tags = req.tags
            )
        )
        return "완료"
    }
}