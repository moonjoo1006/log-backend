package com.theo.log.domain.jpa.repository

import com.theo.log.domain.jpa.entity.ReviewCommentLike
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ReviewCommentLikeRepository : JpaRepository<ReviewCommentLike, Long> {

    fun existsByUserIdAndCommentId(userId: Long, commentId: Long): Boolean

    fun deleteByUserIdAndCommentId(userId: Long, commentId: Long)

    fun countByCommentId(commentId: Long): Long
}