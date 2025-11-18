package com.career.my.application.usecase

import com.career.my.application.dto.DailyLogCommand
import com.career.my.application.dto.DailyLogResult
import com.career.my.application.port.`in`.DailyLogUseCase
import com.career.my.application.port.out.DailyLogPersistencePort
import com.career.my.domain.model.DailyLog
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

// 유스케이스를 구현해 도메인 로직을 조합하는 서비스 클래스
@Service
class DailyLogService(
    private val persistencePort: DailyLogPersistencePort,
) : DailyLogUseCase {

    @Transactional
    override fun create(command: DailyLogCommand.Create) {
        // 입력 명령을 도메인 엔티티로 변환 후 영속성 포트로 위임
        persistencePort.save(
            DailyLog.of(
                userId = command.userId,
                title = command.title,
                content = command.content,
                tags = command.tags,
            )
        )
    }

    @Transactional(readOnly = true)
    override fun get(command: DailyLogCommand.Get): DailyLogResult.Get {
        // 조회된 도메인 엔티티를 유스케이스 결과 모델로 변환해 반환
        val dailyLog = persistencePort.findById(command.id)
        return DailyLogResult.Get(
            dailyLog.id,
            dailyLog.userId,
            dailyLog.title,
            dailyLog.content,
            dailyLog.tags
        )
    }
}
