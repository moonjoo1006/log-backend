package com.theo.log.controller.request

data class UserSignUpRequest(
    val appUserId: Long,
    val nickname: String,
    val email: String?,
    val profileImageUrl: String?,
    val agreedTermsIds: List<Long>,
)