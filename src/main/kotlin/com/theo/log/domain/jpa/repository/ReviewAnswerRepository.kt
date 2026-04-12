package com.theo.log.domain.jpa.repository

import com.theo.log.domain.jpa.entity.ReviewAnswer
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ReviewAnswerRepository : JpaRepository<ReviewAnswer, Long> {

    fun findByReviewIdIn(reviewIds: List<Long>): List<ReviewAnswer>
}
