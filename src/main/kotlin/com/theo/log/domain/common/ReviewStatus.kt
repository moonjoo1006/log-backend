package com.theo.log.domain.common

enum class ReviewStatus(val desc: String) {
    PUBLISHED("작성 완료"),
    DRAFT("임시저장"),
    DELETED("삭제"),
}