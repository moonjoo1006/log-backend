package com.theo.log.controller.response

data class ContentStatsResponse(
    val reviewCount: Long,
    val likeCount: Long,
    val averageRating: Double?,
)