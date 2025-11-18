package com.career.my.application.usecase

import com.career.my.application.dto.DailyLogCommand
import com.career.my.application.port.out.DailyLogPersistencePort
import com.career.my.domain.model.DailyLog
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.mockito.ArgumentCaptor
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify
import org.mockito.kotlin.whenever
import java.util.UUID

class DailyLogServiceTest {

    private val persistencePort: DailyLogPersistencePort = mock(DailyLogPersistencePort::class.java)
    private val service = DailyLogService(persistencePort)

    @Test
    fun `create delegates to persistence port`() {
        // 명령 처리 시 포트가 호출되는지 검증
        val command = DailyLogCommand.Create(
            userId = UUID.randomUUID(),
            title = "제목",
            content = "내용",
            tags = listOf("tag1", "tag2"),
        )

        service.create(command)

        val captor: ArgumentCaptor<DailyLog> = ArgumentCaptor.forClass(DailyLog::class.java)
        verify(persistencePort).save(captor.capture())
        assertEquals(command.title, captor.value.title)
        assertEquals(command.content, captor.value.content)
    }

    @Test
    fun `get maps entity to result`() {
        // 조회된 엔티티가 결과 모델로 정상 변환되는지 확인
        val id = UUID.randomUUID()
        val entity = DailyLog.of(
            userId = UUID.randomUUID(),
            title = "조회 제목",
            content = "조회 내용",
            tags = listOf("kotlin"),
        )

        whenever(persistencePort.findById(id)).thenReturn(entity)

        val result = service.get(DailyLogCommand.Get(id))

        assertEquals(entity.title, result.title)
        assertEquals(entity.content, result.content)
        assertEquals(entity.tags, result.tags)
    }
}
