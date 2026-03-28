package com.theo.log.controller

import com.theo.log.application.ContentApplication
import com.theo.log.controller.response.ContentStatsResponse
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.Parameter
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@Tag(name = "Content", description = "콘텐츠 API")
@RestController
@RequestMapping("/contents")
class ContentController(
    val contentApplication: ContentApplication,
) {

    @Operation(summary = "콘텐츠 통계 조회", description = "리뷰 수, 좋아요 수, 평균 평점 조회")
    @ApiResponses(
        ApiResponse(responseCode = "200", description = "조회 성공"),
    )
    @GetMapping("/{contentId}/stats")
    fun getStats(
        @Parameter(description = "콘텐츠 ID") @PathVariable contentId: Long,
    ): ContentStatsResponse {
        return contentApplication.getStats(contentId)
    }
}