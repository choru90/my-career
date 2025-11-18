package com.career.my.application.port.`in`

import com.career.my.application.dto.DailyLogCommand
import com.career.my.application.dto.DailyLogResult

// 애플리케이션 계층의 입력 포트: 외부에서 호출 가능한 유스케이스 정의
interface DailyLogUseCase {
    fun create(command: DailyLogCommand.Create)
    fun get(command: DailyLogCommand.Get): DailyLogResult.Get
}
