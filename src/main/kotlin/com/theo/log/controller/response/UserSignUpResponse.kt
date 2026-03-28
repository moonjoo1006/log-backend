package com.theo.log.controller.response

data class UserSignUpResponse(
    val id: Long,
    val appUserId: Long,
    val nickname: String,
)