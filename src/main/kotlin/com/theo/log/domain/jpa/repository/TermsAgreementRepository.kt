package com.theo.log.domain.jpa.repository

import com.theo.log.domain.jpa.entity.TermsAgreement
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TermsAgreementRepository : JpaRepository<TermsAgreement, Long>