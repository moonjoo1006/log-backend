package com.theo.log.domain.jpa.service

import com.theo.log.domain.common.ReviewStatus
import com.theo.log.domain.jpa.entity.Review
import com.theo.log.domain.jpa.repository.ReviewRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class ReviewService(val reviewRepository: ReviewRepository) {

    @Transactional(readOnly = true)
    fun countByContent(contentId: Long): Long {
        return reviewRepository.countByContentId(contentId)
    }

    @Transactional(readOnly = true)
    fun averageRatingByContent(contentId: Long): Double? {
        return reviewRepository.averageRatingByContentId(contentId)
    }

    @Transactional(readOnly = true)
    fun findActiveReview(userId: Long, contentId: Long): Review? {
        return reviewRepository.findByUser_IdAndContent_IdAndStatusIn(
            userId, contentId, listOf(ReviewStatus.PUBLISHED, ReviewStatus.DRAFT)
        )
    }

    @Transactional(readOnly = true)
    fun findByContent(contentId: Long, page: Int, size: Int): Page<Review> {
        val pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "id"))
        return reviewRepository.findByContentIdAndStatus(contentId, pageable = pageable)
    }
}