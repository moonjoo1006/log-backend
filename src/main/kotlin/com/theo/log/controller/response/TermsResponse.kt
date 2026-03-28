package com.theo.log.controller.response

import com.theo.log.domain.common.TermsType

data class TermsResponse(
    val id: Long,
    val type: TermsType,
    val version: Int,
    val content: String,
    val required: Boolean,
    val sequence: Int,
)