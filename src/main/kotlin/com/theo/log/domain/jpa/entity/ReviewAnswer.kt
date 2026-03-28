package com.theo.log.domain.jpa.entity

import com.theo.log.domain.common.BaseTimeEntity
import jakarta.persistence.*

@Entity
@Table(name = "review_answer")
class ReviewAnswer(
    val reviewId: Long,

    val reviewQuestionId: Long,

    @Column(columnDefinition = "TEXT", nullable = false)
    val answer: String,
) : BaseTimeEntity() {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0
}
