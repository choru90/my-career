package com.career.my.domain.service

import com.career.my.domain.DailyLog
import com.career.my.domain.dto.DailyLogCommand
import com.career.my.infrastructure.repository.DailyLogRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class DailyLogServiceImpl(
    private val repository: DailyLogRepository
): DailyLogService {

    @Transactional
    override fun create(command: DailyLogCommand.Create) {
        repository.save(DailyLog.of(userId = command.userId, title = command.title, content = command.content, tags = command.tags))
    }
}