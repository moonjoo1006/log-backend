package com.theo.log.domain.jpa.repository

import com.theo.log.domain.common.ReviewStatus
import com.theo.log.domain.jpa.entity.Review
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface ReviewRepository : JpaRepository<Review, Long> {

    fun countByContentId(contentId: Long): Long

    @Query("SELECT AVG(r.rating) FROM Review r WHERE r.content.id = :contentId AND r.rating IS NOT NULL")
    fun averageRatingByContentId(@Param("contentId") contentId: Long): Double?

    fun findByUser_IdAndContent_IdAndStatusIn(userId: Long, contentId: Long, statuses: List<ReviewStatus>): Review?

    @Query(
        value = "SELECT r FROM Review r JOIN FETCH r.user WHERE r.content.id = :contentId AND r.status = :status",
        countQuery = "SELECT COUNT(r) FROM Review r WHERE r.content.id = :contentId AND r.status = :status",
    )
    fun findByContentIdAndStatus(
        @Param("contentId") contentId: Long,
        @Param("status") status: ReviewStatus = ReviewStatus.PUBLISHED,
        pageable: Pageable,
    ): Page<Review>
}