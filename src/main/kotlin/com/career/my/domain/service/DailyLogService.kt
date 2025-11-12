package com.career.my.domain.service

import com.career.my.domain.dto.DailyLogCommand

interface DailyLogService {
    fun create(command: DailyLogCommand.Create)
}