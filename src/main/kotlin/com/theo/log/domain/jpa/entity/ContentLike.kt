package com.theo.log.domain.jpa.entity

import com.theo.log.domain.common.BaseTimeEntity
import jakarta.persistence.*

@Entity
@Table(
    name = "content_like",
    uniqueConstraints = [UniqueConstraint(columnNames = ["user_id", "content_id"])]
)
class ContentLike(
    @Column(name = "user_id", nullable = false)
    val userId: Long,

    @Column(name = "content_id", nullable = false)
    val contentId: Long,

) : BaseTimeEntity() {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0
}