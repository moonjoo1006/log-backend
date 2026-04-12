package com.theo.log.controller.response

import com.theo.log.domain.common.ReviewStatus

data class ContentReviewStatusResponse(
    val exists: Boolean,
    val reviewId: Long?,
    val status: ReviewStatus?,
)