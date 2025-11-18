package com.career.my.domain.model.common

import jakarta.persistence.MappedSuperclass
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime

// 모든 엔티티가 공통으로 사용하는 생성/수정 시간 컬럼을 정의
@MappedSuperclass
class BaseTimeEntity(
    @CreationTimestamp
    val createdAt: LocalDateTime = LocalDateTime.now(),
    @UpdateTimestamp
    val updatedAt: LocalDateTime = LocalDateTime.now(),
)
