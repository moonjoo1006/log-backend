package com.theo.log.controller.response

import java.time.LocalDateTime

data class ReviewCommentResponse(
    val commentId: Long,
    val reviewId: Long,
    val userId: Long,
    val nickname: String,
    val profileImageUrl: String?,
    val content: String,
    val createdAt: LocalDateTime,
)
