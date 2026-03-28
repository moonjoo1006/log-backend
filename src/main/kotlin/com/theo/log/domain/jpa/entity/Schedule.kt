package com.theo.log.domain.jpa.entity

import com.theo.log.domain.common.BaseTimeEntity
import com.theo.log.domain.common.ScheduleStatus
import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "schedule")
class Schedule(
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "content_id", nullable = false)
    val content: Content,

    @Column(nullable = false)
    val startedAt: LocalDateTime,

    @Column(nullable = false)
    val endedAt: LocalDateTime,

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 10)
    val status: ScheduleStatus = ScheduleStatus.ON,

    @Column(length = 200)
    val memo: String? = null,
) : BaseTimeEntity() {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0
}
