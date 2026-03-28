package com.theo.log.application

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
}