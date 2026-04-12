package com.theo.log.controller.response

import java.time.LocalDateTime

data class ReviewListItemResponse(
    val reviewId: Long,
    val userId: Long,
    val nickname: String,
    val profileImageUrl: String?,
    val comment: String?,
    val shortComment: String?,
    val rating: Byte?,
    val quotes: List<ReviewQuoteItemResponse>,
    val questions: List<ReviewQuestionItemResponse>,
    val createdAt: LocalDateTime,
)

data class ReviewQuoteItemResponse(
    val id: Long,
    val quote: String,
    val sequence: Int,
)

data class ReviewQuestionItemResponse(
    val id: Long,
    val question: String,
    val sequence: Int,
    val answer: String?,
)