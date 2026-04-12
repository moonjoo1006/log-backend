package com.theo.log.domain.jpa.repository

import com.theo.log.domain.common.ScheduleStatus
import com.theo.log.domain.jpa.entity.Schedule
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import java.time.LocalDateTime

@Repository
interface ScheduleRepository : JpaRepository<Schedule, Long> {

    @Query("SELECT s FROM Schedule s JOIN FETCH s.content WHERE s.status = :status AND s.startedAt <= :now AND s.endedAt >= :now")
    fun findCurrentSchedules(
        @Param("now") now: LocalDateTime,
        @Param("status") status: ScheduleStatus = ScheduleStatus.ON,
    ): List<Schedule>

    @Query(
        value = "SELECT s FROM Schedule s JOIN FETCH s.content WHERE s.status = :status",
        countQuery = "SELECT COUNT(s) FROM Schedule s WHERE s.status = :status",
    )
    fun findAllWithContent(
        pageable: Pageable,
        @Param("status") status: ScheduleStatus = ScheduleStatus.ON,
    ): Page<Schedule>
}
