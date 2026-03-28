package com.theo.log.domain.jpa.repository

import com.theo.log.domain.jpa.entity.Review
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface ReviewRepository : JpaRepository<Review, Long> {

    fun countByContentId(contentId: Long): Long

    @Query("SELECT AVG(r.rating) FROM Review r WHERE r.content.id = :contentId AND r.rating IS NOT NULL")
    fun averageRatingByContentId(@Param("contentId") contentId: Long): Double?
}