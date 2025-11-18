package com.career.my.domain.service

import com.career.my.domain.DailyLog
import com.career.my.domain.dto.DailyLogCommand
import com.career.my.domain.dto.DailyLogResponse
import com.career.my.infrastructure.repository.DailyLogRepository
import jakarta.persistence.EntityNotFoundException
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

    @Transactional(readOnly = true)
    override fun get(command: DailyLogCommand.Get): DailyLogResponse.Get {
        val dailyLog = repository.findById(command.id).orElseThrow { EntityNotFoundException() }
        return DailyLogResponse.Get(dailyLog.id, dailyLog.userId, dailyLog.title, dailyLog.content, dailyLog.tags)
    }
}