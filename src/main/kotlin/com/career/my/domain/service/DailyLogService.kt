package com.career.my.domain.service

import com.career.my.domain.dto.DailyLogCommand
import com.career.my.domain.dto.DailyLogResponse

interface DailyLogService {
    fun create(command: DailyLogCommand.Create)
    fun get(command: DailyLogCommand.Get): DailyLogResponse.Get
}