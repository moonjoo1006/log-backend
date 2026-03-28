package com.theo.log.domain.jpa.service

import com.theo.log.domain.jpa.entity.TermsAgreement
import com.theo.log.domain.jpa.repository.TermsAgreementRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class TermsAgreementService(val termsAgreementRepository: TermsAgreementRepository) {

    @Transactional
    fun saveAll(agreements: List<TermsAgreement>) {
        termsAgreementRepository.saveAll(agreements)
    }
}