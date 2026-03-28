package com.theo.log.domain.jpa.entity

import com.theo.log.domain.common.BaseTimeEntity
import jakarta.persistence.*

@Entity
@Table(name = "review_question")
class ReviewQuestion(
    val reviewId: Long,

    @Column(nullable = false, length = 128)
    val question: String,

    @Column(nullable = false)
    val sequence: Int = 0,
) : BaseTimeEntity() {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0
}
