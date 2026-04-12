package com.theo.log.domain.jpa.service

import com.theo.log.domain.jpa.entity.ReviewQuote
import com.theo.log.domain.jpa.repository.ReviewQuoteRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class ReviewQuoteService(val reviewQuoteRepository: ReviewQuoteRepository) {

    @Transactional(readOnly = true)
    fun findByReviewIds(reviewIds: List<Long>): List<ReviewQuote> {
        if (reviewIds.isEmpty()) return emptyList()
        return reviewQuoteRepository.findByReviewIdIn(reviewIds)
    }
}