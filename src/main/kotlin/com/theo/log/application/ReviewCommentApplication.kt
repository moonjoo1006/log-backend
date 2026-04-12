package com.theo.log.application

import com.theo.log.controller.request.ReviewCommentCreateRequest
import com.theo.log.controller.response.ReviewCommentLikeResponse
import com.theo.log.controller.response.ReviewCommentResponse
import com.theo.log.domain.jpa.service.ReviewCommentLikeService
import com.theo.log.domain.jpa.service.ReviewCommentService
import com.theo.log.domain.jpa.service.UserService
import org.springframework.stereotype.Service

@Service
class ReviewCommentApplication(
    val reviewCommentService: ReviewCommentService,
    val reviewCommentLikeService: ReviewCommentLikeService,
    val userService: UserService,
) {

    fun createComment(reviewId: Long, userId: Long, request: ReviewCommentCreateRequest): ReviewCommentResponse {
        val user = userService.getById(userId)
        val comment = reviewCommentService.create(reviewId = reviewId, user = user, content = request.content)
        return ReviewCommentResponse(
            commentId = comment.id,
            reviewId = comment.reviewId,
            userId = comment.user.id,
            nickname = comment.user.nickname,
            profileImageUrl = comment.user.profileImageUrl,
            content = comment.content,
            createdAt = comment.createdAt,
        )
    }

    fun toggleLike(userId: Long, commentId: Long): ReviewCommentLikeResponse {
        reviewCommentLikeService.toggle(userId, commentId)
        return ReviewCommentLikeResponse(
            liked = reviewCommentLikeService.isLiked(userId, commentId),
            likeCount = reviewCommentLikeService.countByComment(commentId),
        )
    }
}
