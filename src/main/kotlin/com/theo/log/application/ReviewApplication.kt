package com.theo.log.application

import com.theo.log.controller.response.ReviewListItemResponse
import com.theo.log.controller.response.ReviewQuestionItemResponse
import com.theo.log.controller.response.ReviewQuoteItemResponse
import com.theo.log.domain.jpa.service.ReviewAnswerService
import com.theo.log.domain.jpa.service.ReviewQuestionService
import com.theo.log.domain.jpa.service.ReviewQuoteService
import com.theo.log.domain.jpa.service.ReviewService
import org.springframework.data.domain.Page
import org.springframework.stereotype.Service

@Service
class ReviewApplication(
    val reviewService: ReviewService,
    val reviewQuoteService: ReviewQuoteService,
    val reviewQuestionService: ReviewQuestionService,
    val reviewAnswerService: ReviewAnswerService,
) {

    fun getReviews(contentId: Long, page: Int, size: Int): Page<ReviewListItemResponse> {
        val reviewPage = reviewService.findByContent(contentId, page, size)
        val reviewIds = reviewPage.content.map { it.id }

        val quotesByReviewId = reviewQuoteService.findByReviewIds(reviewIds).groupBy { it.reviewId }
        val questionsByReviewId = reviewQuestionService.findByReviewIds(reviewIds).groupBy { it.reviewId }
        val answersByQuestionId = reviewAnswerService.findByReviewIds(reviewIds).associateBy { it.reviewQuestionId }

        return reviewPage.map { review ->
            val quotes = (quotesByReviewId[review.id] ?: emptyList())
                .sortedBy { it.sequence }
                .map { ReviewQuoteItemResponse(id = it.id, quote = it.quote, sequence = it.sequence) }

            val questions = (questionsByReviewId[review.id] ?: emptyList())
                .sortedBy { it.sequence }
                .map { q ->
                    ReviewQuestionItemResponse(
                        id = q.id,
                        question = q.question,
                        sequence = q.sequence,
                        answer = answersByQuestionId[q.id]?.answer,
                    )
                }

            ReviewListItemResponse(
                reviewId = review.id,
                userId = review.user.id,
                nickname = review.user.nickname,
                profileImageUrl = review.user.profileImageUrl,
                comment = review.comment,
                shortComment = review.shortComment,
                rating = review.rating,
                quotes = quotes,
                questions = questions,
                createdAt = review.createdAt,
            )
        }
    }
}