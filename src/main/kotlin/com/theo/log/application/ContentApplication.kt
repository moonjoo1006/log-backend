package com.theo.log.application

import com.theo.log.controller.response.ContentLikeResponse
import com.theo.log.controller.response.ContentReviewStatusResponse
import com.theo.log.controller.response.ContentStatsResponse
import com.theo.log.domain.jpa.service.ContentLikeService
import com.theo.log.domain.jpa.service.ReviewService
import org.springframework.stereotype.Service

@Service
class ContentApplication(
    val reviewService: ReviewService,
    val contentLikeService: ContentLikeService,
) {

    fun getStats(contentId: Long): ContentStatsResponse {
        return ContentStatsResponse(
            reviewCount = reviewService.countByContent(contentId),
            likeCount = contentLikeService.countByContent(contentId),
            averageRating = reviewService.averageRatingByContent(contentId),
        )
    }

    fun toggleLike(userId: Long, contentId: Long): ContentLikeResponse {
        contentLikeService.toggle(userId, contentId)
        return ContentLikeResponse(
            liked = contentLikeService.isLiked(userId, contentId),
            likeCount = contentLikeService.countByContent(contentId),
        )
    }

    fun getLikeStatus(userId: Long, contentId: Long): ContentLikeResponse {
        return ContentLikeResponse(
            liked = contentLikeService.isLiked(userId, contentId),
            likeCount = contentLikeService.countByContent(contentId),
        )
    }

    fun getReviewStatus(userId: Long, contentId: Long): ContentReviewStatusResponse {
        val review = reviewService.findActiveReview(userId, contentId)
        return ContentReviewStatusResponse(
            exists = review != null,
            reviewId = review?.id,
            status = review?.status,
        )
    }
}