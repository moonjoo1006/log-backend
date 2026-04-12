package com.theo.log.domain.jpa.repository

import com.theo.log.domain.jpa.entity.ReviewQuote
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ReviewQuoteRepository : JpaRepository<ReviewQuote, Long> {

    fun findByReviewIdIn(reviewIds: List<Long>): List<ReviewQuote>
}
