package com.theo.log.application

import com.theo.log.controller.request.UserSignUpRequest
import com.theo.log.controller.response.UserSignUpResponse
import com.theo.log.domain.common.UserStatus
import com.theo.log.domain.exception.DuplicateUserException
import com.theo.log.domain.jpa.entity.TermsAgreement
import com.theo.log.domain.jpa.entity.User
import com.theo.log.domain.jpa.service.TermsAgreementService
import com.theo.log.domain.jpa.service.UserService
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UserApplication(
    val userService: UserService,
    val termsAgreementService: TermsAgreementService,
) {

    @Transactional
    fun signUp(request: UserSignUpRequest): UserSignUpResponse {
        val existingUser = userService.findByAppUserId(request.appUserId)

        val user = when (existingUser?.status) {
            UserStatus.JOIN -> throw DuplicateUserException()
            UserStatus.WITHDRAW -> {
                existingUser.reJoin(
                    nickname = request.nickname,
                    email = request.email,
                    profileImageUrl = request.profileImageUrl,
                )
                existingUser
            }
            null -> userService.save(
                User(
                    appUserId = request.appUserId,
                    nickname = request.nickname,
                    email = request.email,
                    profileImageUrl = request.profileImageUrl,
                    status = UserStatus.JOIN,
                )
            )
        }

        termsAgreementService.saveAll(
            request.agreedTermsIds.map { termsId ->
                TermsAgreement(
                    userId = user.id,
                    termsId = termsId,
                    agreed = true,
                )
            }
        )

        return UserSignUpResponse(
            id = user.id,
            appUserId = user.appUserId,
            nickname = user.nickname,
        )
    }
}