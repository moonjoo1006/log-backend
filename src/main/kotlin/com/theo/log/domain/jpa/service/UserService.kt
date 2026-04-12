package com.theo.log.domain.jpa.service

import com.theo.log.domain.jpa.entity.User
import com.theo.log.domain.jpa.repository.UserRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UserService(val userRepository: UserRepository) {

    @Transactional
    fun save(user: User): User {
        return userRepository.save(user)
    }

    @Transactional(readOnly = true)
    fun findByAppUserId(appUserId: Long): User? {
        return userRepository.findByAppUserId(appUserId)
    }

    @Transactional(readOnly = true)
    fun getById(id: Long): User {
        return userRepository.findById(id).orElseThrow { NoSuchElementException("존재하지 않는 유저입니다.") }
    }
}