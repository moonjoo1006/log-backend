package com.theo.log.domain.jpa.service

import com.theo.log.domain.jpa.entity.ContentLike
import com.theo.log.domain.jpa.repository.ContentLikeRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class ContentLikeService(val contentLikeRepository: ContentLikeRepository) {

    @Transactional
    fun toggle(userId: Long, contentId: Long) {
        if (contentLikeRepository.existsByUserIdAndContentId(userId, contentId)) {
            contentLikeRepository.deleteByUserIdAndContentId(userId, contentId)
        } else {
            contentLikeRepository.save(ContentLike(userId = userId, contentId = contentId))
        }
    }

    @Transactional(readOnly = true)
    fun isLiked(userId: Long, contentId: Long): Boolean {
        return contentLikeRepository.existsByUserIdAndContentId(userId, contentId)
    }

    @Transactional(readOnly = true)
    fun countByContent(contentId: Long): Long {
        return contentLikeRepository.countByContentId(contentId)
    }
}