package com.theo.log.domain.jpa.entity

import com.theo.log.domain.common.BaseTimeEntity
import com.theo.log.domain.common.TermsStatus
import com.theo.log.domain.common.TermsType
import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "terms")
class Terms(
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 16)
    val type: TermsType,

    @Column(nullable = false)
    val version: Int,

    @Column(nullable = false, length = 128)
    val content: String,

    @Column(nullable = false)
    val required: Boolean,

    @Column(nullable = false)
    val startedAt: LocalDateTime,

    @Column
    val endedAt: LocalDateTime,

    @Column(nullable = false)
    val sequence: Int = 0,

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 16)
    val status: TermsStatus = TermsStatus.ACTIVE,
) : BaseTimeEntity() {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0
}