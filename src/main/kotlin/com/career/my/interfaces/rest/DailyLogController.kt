package com.career.my.interfaces.rest

import com.career.my.application.dto.DailyLogCommand
import com.career.my.application.port.`in`.DailyLogUseCase
import com.career.my.interfaces.rest.dto.DailyLogRequest
import com.career.my.interfaces.rest.dto.DailyLogResponse
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.tags.Tag
import jakarta.validation.Valid
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*

@Tag(name = "DailyLog", description = "데일리 로그 API")
@RestController
@RequestMapping("/daily-logs")
@Validated
class DailyLogController(
    private val useCase: DailyLogUseCase,
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
        // REST 요청을 애플리케이션 명령으로 변환하여 입력 포트 호출
        useCase.create(
            DailyLogCommand.Create(
                userId = req.userId,
                title = req.title,
                content = req.content,
                tags = req.tags,
            )
        )
        return "완료"
    }

    @GetMapping("/{id}")
    fun get(@PathVariable id: String): DailyLogResponse.Get {
        // 요청 경로의 식별자를 포트 명령으로 전달 후 응답 DTO로 변환
        val result = useCase.get(DailyLogCommand.Get(java.util.UUID.fromString(id)))
        return DailyLogResponse.Get(result.id, result.userId, result.title, result.content, result.tags)
    }
}
