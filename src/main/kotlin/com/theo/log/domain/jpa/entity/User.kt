package com.theo.log.domain.jpa.entity

import com.theo.log.domain.common.BaseTimeEntity
import com.theo.log.domain.common.UserStatus
import jakarta.persistence.*

@Entity
@Table(name = "users")
class User(
    @Column(nullable = false, unique = true)
    val appUserId: Long,

    @Column(nullable = false, unique = true, length = 32)
    var nickname: String,

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 16)
    var status: UserStatus,

    @Column(length = 32)
    var email: String? = null,

    @Column(length = 512)
    var profileImageUrl: String? = null,

) : BaseTimeEntity() {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0

    fun reJoin(nickname: String, email: String?, profileImageUrl: String?) {
        this.nickname = nickname
        this.email = email
        this.profileImageUrl = profileImageUrl
        this.status = UserStatus.JOIN
    }
}