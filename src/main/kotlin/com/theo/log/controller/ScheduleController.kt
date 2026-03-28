package com.theo.log.controller

import com.theo.log.application.ScheduleApplication
import com.theo.log.controller.response.ScheduledContentResponse
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@Tag(name = "Schedule", description = "스케줄 API")
@RestController
@RequestMapping("/schedules")
class ScheduleController(
    val scheduleApplication: ScheduleApplication,
) {

    @Operation(summary = "이번 기간 읽어야 할 책 조회", description = "현재 날짜 기준 유효한 스케줄의 책 목록 조회")
    @ApiResponses(
        ApiResponse(responseCode = "200", description = "조회 성공"),
    )
    @GetMapping("/current")
    fun getCurrentSchedules(): List<ScheduledContentResponse> {
        return scheduleApplication.getCurrentSchedules()
    }
}