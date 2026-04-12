package com.theo.log.domain.jpa.service

import com.theo.log.domain.jpa.entity.ReviewCommentLike
import com.theo.log.domain.jpa.repository.ReviewCommentLikeRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class ReviewCommentLikeService(val reviewCommentLikeRepository: ReviewCommentLikeRepository) {

    @Transactional
    fun toggle(userId: Long, commentId: Long) {
        if (reviewCommentLikeRepository.existsByUserIdAndCommentId(userId, commentId)) {
            reviewCommentLikeRepository.deleteByUserIdAndCommentId(userId, commentId)
        } else {
            reviewCommentLikeRepository.save(ReviewCommentLike(userId = userId, commentId = commentId))
        }
    }

    @Transactional(readOnly = true)
    fun isLiked(userId: Long, commentId: Long): Boolean {
        return reviewCommentLikeRepository.existsByUserIdAndCommentId(userId, commentId)
    }

    @Transactional(readOnly = true)
    fun countByComment(commentId: Long): Long {
        return reviewCommentLikeRepository.countByCommentId(commentId)
    }
}
