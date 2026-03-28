package com.theo.log.domain.jpa.entity

import com.theo.log.domain.common.BaseTimeEntity
import com.theo.log.domain.common.CategoryType
import jakarta.persistence.*

@Entity
@Table(name = "content")
class Content(
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    val categoryType: CategoryType,

    @Column(nullable = false)
    val title: String,

    @Column(columnDefinition = "TEXT")
    val description: String? = null,

    @Column(length = 500)
    val coverImageUrl: String? = null,

    // 책 전용
    val author: String? = null,
    val publisher: String? = null,

    @Column(length = 20, unique = true)
    val isbn: String? = null,

    // 영화 전용
    val director: String? = null,
    val runtimeMinutes: Int? = null,
) : BaseTimeEntity() {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0
}
