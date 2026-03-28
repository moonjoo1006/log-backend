package com.theo.log.application

import com.theo.log.controller.response.TermsResponse
import com.theo.log.domain.jpa.service.TermsService
import org.springframework.stereotype.Service

@Service
class TermsApplication(
    val termsService: TermsService,
) {

    fun getActiveTerms(): List<TermsResponse> {
        return termsService.findActiveTerms().map { terms ->
            TermsResponse(
                id = terms.id,
                type = terms.type,
                version = terms.version,
                content = terms.content,
                required = terms.required,
                sequence = terms.sequence,
            )
        }
    }
}