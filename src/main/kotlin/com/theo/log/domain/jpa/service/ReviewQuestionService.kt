package com.theo.log.domain.jpa.service

import com.theo.log.domain.jpa.entity.ReviewQuestion
import com.theo.log.domain.jpa.repository.ReviewQuestionRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class ReviewQuestionService(val reviewQuestionRepository: ReviewQuestionRepository) {

    @Transactional(readOnly = true)
    fun findByReviewIds(reviewIds: List<Long>): List<ReviewQuestion> {
        if (reviewIds.isEmpty()) return emptyList()
        return reviewQuestionRepository.findByReviewIdIn(reviewIds)
    }
}