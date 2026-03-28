package com.theo.log.application

import com.theo.log.controller.response.ScheduledContentResponse
import com.theo.log.domain.jpa.service.ScheduleService
import org.springframework.stereotype.Service

@Service
class ScheduleApplication(
    val scheduleService: ScheduleService,
) {

    fun getCurrentSchedules(): List<ScheduledContentResponse> {
        return scheduleService.findCurrentSchedules().map { schedule ->
            ScheduledContentResponse(
                scheduleId = schedule.id,
                contentId = schedule.content.id,
                categoryType = schedule.content.categoryType,
                title = schedule.content.title,
                description = schedule.content.description,
                author = schedule.content.author,
                coverImageUrl = schedule.content.coverImageUrl,
                startedAt = schedule.startedAt,
                endedAt = schedule.endedAt,
                memo = schedule.memo,
            )
        }
    }
}