package com.career.my.application.port.out

import com.career.my.domain.model.DailyLog
import java.util.UUID

// 도메인 객체를 영속화하기 위한 출력 포트 정의
interface DailyLogPersistencePort {
    fun save(dailyLog: DailyLog): DailyLog
    fun findById(id: UUID): DailyLog
}
