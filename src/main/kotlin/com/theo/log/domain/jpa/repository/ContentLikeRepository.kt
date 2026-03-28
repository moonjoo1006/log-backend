package com.theo.log.domain.jpa.repository

import com.theo.log.domain.jpa.entity.ContentLike
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ContentLikeRepository : JpaRepository<ContentLike, Long> {

    fun existsByUserIdAndContentId(userId: Long, contentId: Long): Boolean

    fun deleteByUserIdAndContentId(userId: Long, contentId: Long)

    fun countByContentId(contentId: Long): Long
}