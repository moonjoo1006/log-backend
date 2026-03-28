package com.theo.log.domain.jpa.entity

import com.theo.log.domain.common.BaseTimeEntity
import jakarta.persistence.*

@Entity
@Table(name = "terms_agreement")
class TermsAgreement(
    @Column(name = "user_id", nullable = false)
    val userId: Long,

    @Column(name = "terms_id", nullable = false)
    val termsId: Long,

    @Column(nullable = false)
    val agreed: Boolean,
) : BaseTimeEntity() {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0
}