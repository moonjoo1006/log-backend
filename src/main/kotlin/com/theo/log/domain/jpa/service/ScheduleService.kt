package com.theo.log.domain.jpa.service

import com.theo.log.domain.jpa.entity.Schedule
import com.theo.log.domain.jpa.repository.ScheduleRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDateTime

@Service
class ScheduleService(val scheduleRepository: ScheduleRepository) {

    @Transactional(readOnly = true)
    fun findCurrentSchedules(): List<Schedule> {
        return scheduleRepository.findCurrentSchedules(now = LocalDateTime.now())
    }

    @Transactional(readOnly = true)
    fun findSchedules(page: Int, size: Int): Page<Schedule> {
        val pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "id"))
        return scheduleRepository.findAllWithContent(pageable)
    }
}