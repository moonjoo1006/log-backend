package com.theo.log.controller

import com.theo.log.application.UserApplication
import com.theo.log.controller.request.UserSignUpRequest
import com.theo.log.controller.response.UserSignUpResponse
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@Tag(name = "User", description = "유저 API")
@RestController
@RequestMapping("/users")
class UserController(
    val userApplication: UserApplication,
) {

    @Operation(summary = "회원가입", description = "신규 가입 또는 탈퇴 유저 재가입 처리")
    @ApiResponses(
        ApiResponse(responseCode = "201", description = "가입 성공"),
        ApiResponse(responseCode = "409", description = "이미 가입된 유저"),
    )
    @PostMapping("/sign-up")
    @ResponseStatus(HttpStatus.CREATED)
    fun signUp(@RequestBody request: UserSignUpRequest): UserSignUpResponse {
        return userApplication.signUp(request)
    }
}