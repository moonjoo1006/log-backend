package com.theo.log.controller

import com.theo.log.application.ScheduleApplication
import com.theo.log.controller.response.SchedulePageResponse
import com.theo.log.controller.response.ScheduledContentResponse
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.Parameter
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.data.domain.Page
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
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

    @Operation(summary = "스케줄 목록 조회", description = "전체 스케줄 목록을 ID 내림차순으로 페이지네이션 조회")
    @ApiResponses(
        ApiResponse(responseCode = "200", description = "조회 성공"),
    )
    @GetMapping
    fun getSchedules(
        @Parameter(description = "페이지 번호 (0부터 시작)") @RequestParam(defaultValue = "0") page: Int,
        @Parameter(description = "페이지 크기") @RequestParam(defaultValue = "20") size: Int,
    ): Page<SchedulePageResponse> {
        return scheduleApplication.getSchedules(page, size)
    }
}