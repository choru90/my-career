package com.career.my.infrastructure.repository

import com.career.my.domain.DailyLog
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface DailyLogRepository : JpaRepository<DailyLog, UUID> {
}