package com.theo.log.domain.jpa.repository

import com.theo.log.domain.jpa.entity.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : JpaRepository<User, Long> {

    fun findByAppUserId(appUserId: Long): User?
}