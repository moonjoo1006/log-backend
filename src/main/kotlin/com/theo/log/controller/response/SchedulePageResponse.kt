package com.theo.log.controller.response

import java.time.LocalDateTime

data class SchedulePageResponse(
    val scheduleId: Long,
    val contentId: Long,
    val title: String,
    val coverImageUrl: String?,
    val startedAt: LocalDateTime,
    val endedAt: LocalDateTime,
)