package com.theo.log.controller.response

import com.theo.log.domain.common.CategoryType
import java.time.LocalDateTime

data class ScheduledContentResponse(
    val scheduleId: Long,
    val contentId: Long,
    val categoryType: CategoryType,
    val title: String,
    val description: String?,
    val author: String?,
    val coverImageUrl: String?,
    val startedAt: LocalDateTime,
    val endedAt: LocalDateTime,
    val memo: String?,
)