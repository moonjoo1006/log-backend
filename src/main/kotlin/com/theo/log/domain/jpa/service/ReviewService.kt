package com.theo.log.domain.jpa.service

import com.theo.log.domain.jpa.repository.ReviewRepository
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
}