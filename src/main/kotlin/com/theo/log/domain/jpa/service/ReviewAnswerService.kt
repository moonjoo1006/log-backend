package com.theo.log.domain.jpa.service

import com.theo.log.domain.jpa.entity.ReviewAnswer
import com.theo.log.domain.jpa.repository.ReviewAnswerRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class ReviewAnswerService(val reviewAnswerRepository: ReviewAnswerRepository) {

    @Transactional(readOnly = true)
    fun findByReviewIds(reviewIds: List<Long>): List<ReviewAnswer> {
        if (reviewIds.isEmpty()) return emptyList()
        return reviewAnswerRepository.findByReviewIdIn(reviewIds)
    }
}