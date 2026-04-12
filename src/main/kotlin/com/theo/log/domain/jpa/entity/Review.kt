package com.theo.log.domain.jpa.entity

import com.theo.log.domain.common.BaseTimeEntity
import com.theo.log.domain.common.ReviewStatus
import jakarta.persistence.*

@Entity
@Table(
    name = "review"
)
class Review(
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    val user: User,

    // challenge.content와 중복이지만 content 기준 조회를 위한 비정규화
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "content_id", nullable = false)
    val content: Content,

    @Column(name = "comment", columnDefinition = "TEXT")
    val comment: String? = null,

    @Column(length = 512)
    val shortComment: String? = null,

    val rating: Byte? = null,

    @Column(nullable = false)
    val visible: Boolean = true,

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 16)
    val status: ReviewStatus = ReviewStatus.PUBLISHED,

) : BaseTimeEntity() {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0
}