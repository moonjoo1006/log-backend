package com.theo.log.domain.jpa.service

import com.theo.log.domain.jpa.entity.Terms
import com.theo.log.domain.jpa.repository.TermsRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDateTime

@Service
class TermsService(val termsRepository: TermsRepository) {

    @Transactional(readOnly = true)
    fun findActiveTerms(): List<Terms> {
        return termsRepository.findActiveTerms(now = LocalDateTime.now())
    }
}