package com.career.my.infrastructure.persistence

import com.career.my.application.port.out.DailyLogPersistencePort
import com.career.my.domain.model.DailyLog
import jakarta.persistence.EntityNotFoundException
import org.springframework.stereotype.Component
import java.util.UUID

// JPA 구현체를 통해 포트 계약을 충족하는 어댑터
@Component
class DailyLogPersistenceAdapter(
    private val repository: SpringDataDailyLogRepository,
) : DailyLogPersistencePort {

    override fun save(dailyLog: DailyLog): DailyLog {
        // 스프링 데이터 JPA 저장 로직 위임
        return repository.save(dailyLog)
    }

    override fun findById(id: UUID): DailyLog {
        // 존재하지 않는 경우 명확한 예외 메시지를 제공
        return repository.findById(id).orElseThrow { EntityNotFoundException("데일리 로그를 찾을 수 없습니다.") }
    }
}
