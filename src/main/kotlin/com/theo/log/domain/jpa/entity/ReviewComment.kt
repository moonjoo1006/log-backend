package com.theo.log.domain.jpa.entity

import com.theo.log.domain.common.BaseTimeEntity
import com.theo.log.domain.common.CommentStatus
import jakarta.persistence.*

@Entity
@Table(name = "review_comment")
class ReviewComment(
    @Column(name = "review_id", nullable = false)
    val reviewId: Long,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    val user: User,

    @Column(columnDefinition = "TEXT", nullable = false)
    val content: String,

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 16)
    val status: CommentStatus = CommentStatus.ACTIVE,

) : BaseTimeEntity() {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0
}