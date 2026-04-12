package com.theo.log.domain.jpa.service

import com.theo.log.domain.jpa.entity.ReviewComment
import com.theo.log.domain.jpa.entity.User
import com.theo.log.domain.jpa.repository.ReviewCommentRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class ReviewCommentService(val reviewCommentRepository: ReviewCommentRepository) {

    @Transactional
    fun create(reviewId: Long, user: User, content: String): ReviewComment {
        return reviewCommentRepository.save(
            ReviewComment(reviewId = reviewId, user = user, content = content)
        )
    }
}