package com.theo.log.domain.jpa.entity

import com.theo.log.domain.common.BaseTimeEntity
import jakarta.persistence.*

@Entity
@Table(
    name = "review_comment_like",
    uniqueConstraints = [UniqueConstraint(columnNames = ["user_id", "comment_id"])]
)
class ReviewCommentLike(
    @Column(name = "user_id", nullable = false)
    val userId: Long,

    @Column(name = "comment_id", nullable = false)
    val commentId: Long,

) : BaseTimeEntity() {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0
}