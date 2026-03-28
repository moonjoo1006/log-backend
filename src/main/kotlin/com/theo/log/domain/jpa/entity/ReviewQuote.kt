package com.theo.log.domain.jpa.entity

import com.theo.log.domain.common.BaseTimeEntity
import jakarta.persistence.*

@Entity
@Table(name = "review_quote")
class ReviewQuote(
    val reviewId: Long,

    @Column(columnDefinition = "TEXT", nullable = false)
    val quote: String,

    @Column(nullable = false)
    val sequence: Int = 0,
) : BaseTimeEntity() {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0
}
