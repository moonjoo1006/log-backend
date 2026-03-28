package com.theo.log.controller

import com.theo.log.application.TermsApplication
import com.theo.log.controller.response.TermsResponse
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@Tag(name = "Terms", description = "약관 API")
@RestController
@RequestMapping("/terms")
class TermsController(
    val termsApplication: TermsApplication,
) {

    @Operation(summary = "가입 약관 목록 조회", description = "현재 날짜 기준 유효한 약관 목록을 순서대로 조회")
    @ApiResponses(
        ApiResponse(responseCode = "200", description = "조회 성공"),
    )
    @GetMapping
    fun getActiveTerms(): List<TermsResponse> {
        return termsApplication.getActiveTerms()
    }
}