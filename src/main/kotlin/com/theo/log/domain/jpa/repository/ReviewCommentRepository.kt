package com.theo.log.domain.jpa.repository

import com.theo.log.domain.common.CommentStatus
import com.theo.log.domain.jpa.entity.ReviewComment
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface ReviewCommentRepository : JpaRepository<ReviewComment, Long> {

    @Query(
        value = "SELECT c FROM ReviewComment c JOIN FETCH c.user WHERE c.reviewId = :reviewId AND c.status = :status",
        countQuery = "SELECT COUNT(c) FROM ReviewComment c WHERE c.reviewId = :reviewId AND c.status = :status",
    )
    fun findByReviewIdAndStatus(
        @Param("reviewId") reviewId: Long,
        @Param("status") status: CommentStatus = CommentStatus.ACTIVE,
        pageable: Pageable,
    ): Page<ReviewComment>
}