package com.theo.log.controller

import com.theo.log.application.ReviewCommentApplication
import com.theo.log.controller.request.ReviewCommentCreateRequest
import com.theo.log.controller.response.ReviewCommentLikeResponse
import com.theo.log.controller.response.ReviewCommentResponse
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.Parameter
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@Tag(name = "ReviewComment", description = "리뷰 댓글 API")
@RestController
@RequestMapping("/reviews")
class ReviewCommentController(
    val reviewCommentApplication: ReviewCommentApplication,
) {

    @Operation(summary = "리뷰 댓글 작성", description = "리뷰에 댓글을 작성")
    @ApiResponses(
        ApiResponse(responseCode = "201", description = "작성 성공"),
    )
    @PostMapping("/{reviewId}/comments")
    @ResponseStatus(HttpStatus.CREATED)
    fun createComment(
        @Parameter(description = "리뷰 ID") @PathVariable reviewId: Long,
        @Parameter(description = "유저 ID") @RequestHeader("X-User-Id") userId: Long,
        @RequestBody request: ReviewCommentCreateRequest,
    ): ReviewCommentResponse {
        return reviewCommentApplication.createComment(reviewId, userId, request)
    }

    @Operation(summary = "댓글 좋아요 선택/취소", description = "좋아요가 없으면 추가, 있으면 취소 (토글)")
    @ApiResponses(
        ApiResponse(responseCode = "200", description = "처리 성공"),
    )
    @PostMapping("/comments/{commentId}/like")
    fun toggleCommentLike(
        @Parameter(description = "댓글 ID") @PathVariable commentId: Long,
        @Parameter(description = "유저 ID") @RequestHeader("X-User-Id") userId: Long,
    ): ReviewCommentLikeResponse {
        return reviewCommentApplication.toggleLike(userId, commentId)
    }
}
