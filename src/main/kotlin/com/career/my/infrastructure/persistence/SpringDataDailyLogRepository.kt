package com.career.my.infrastructure.persistence

import com.career.my.domain.model.DailyLog
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

// 스프링 데이터 JPA가 구현을 생성하는 기본 리포지토리
interface SpringDataDailyLogRepository : JpaRepository<DailyLog, UUID>
