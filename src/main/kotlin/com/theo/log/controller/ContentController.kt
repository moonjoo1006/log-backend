package com.theo.log.controller

import com.theo.log.application.ContentApplication
import com.theo.log.application.ReviewApplication
import com.theo.log.controller.response.ContentLikeResponse
import com.theo.log.controller.response.ContentReviewStatusResponse
import com.theo.log.controller.response.ContentStatsResponse
import com.theo.log.controller.response.ReviewListItemResponse
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.Parameter
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.data.domain.Page
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@Tag(name = "Content", description = "콘텐츠 API")
@RestController
@RequestMapping("/contents")
class ContentController(
    val contentApplication: ContentApplication,
    val reviewApplication: ReviewApplication,
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

    @Operation(summary = "콘텐츠 좋아요 선택/취소", description = "좋아요가 없으면 추가, 있으면 취소 (토글)")
    @ApiResponses(
        ApiResponse(responseCode = "200", description = "처리 성공"),
    )
    @PostMapping("/{contentId}/like")
    fun toggleLike(
        @Parameter(description = "콘텐츠 ID") @PathVariable contentId: Long,
        @Parameter(description = "유저 ID") @RequestHeader("X-User-Id") userId: Long,
    ): ContentLikeResponse {
        return contentApplication.toggleLike(userId, contentId)
    }

    @Operation(summary = "콘텐츠 좋아요 여부 조회", description = "해당 유저가 콘텐츠에 좋아요를 눌렀는지 조회")
    @ApiResponses(
        ApiResponse(responseCode = "200", description = "조회 성공"),
    )
    @GetMapping("/{contentId}/like")
    fun getLikeStatus(
        @Parameter(description = "콘텐츠 ID") @PathVariable contentId: Long,
        @Parameter(description = "유저 ID") @RequestHeader("X-User-Id") userId: Long,
    ): ContentLikeResponse {
        return contentApplication.getLikeStatus(userId, contentId)
    }

    @Operation(summary = "콘텐츠 리뷰 작성 상태 조회", description = "작성 완료 또는 임시저장된 리뷰가 있는지 조회. exists=false면 작성하기, true면 수정하기 버튼 노출")
    @ApiResponses(
        ApiResponse(responseCode = "200", description = "조회 성공"),
    )
    @GetMapping("/{contentId}/review-status")
    fun getReviewStatus(
        @Parameter(description = "콘텐츠 ID") @PathVariable contentId: Long,
        @Parameter(description = "유저 ID") @RequestHeader("X-User-Id") userId: Long,
    ): ContentReviewStatusResponse {
        return contentApplication.getReviewStatus(userId, contentId)
    }

    @Operation(summary = "콘텐츠 리뷰 목록 조회", description = "해당 콘텐츠의 작성 완료된 리뷰 목록을 ID 내림차순으로 페이지네이션 조회. 각 리뷰에 감명깊은 문구, 질의응답 포함")
    @ApiResponses(
        ApiResponse(responseCode = "200", description = "조회 성공"),
    )
    @GetMapping("/{contentId}/reviews")
    fun getReviews(
        @Parameter(description = "콘텐츠 ID") @PathVariable contentId: Long,
        @Parameter(description = "페이지 번호 (0부터 시작)") @RequestParam(defaultValue = "0") page: Int,
        @Parameter(description = "페이지 크기") @RequestParam(defaultValue = "20") size: Int,
    ): Page<ReviewListItemResponse> {
        return reviewApplication.getReviews(contentId, page, size)
    }
}