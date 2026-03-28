package com.theo.log.domain.jpa.repository

import com.theo.log.domain.common.TermsStatus
import com.theo.log.domain.jpa.entity.Terms
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import java.time.LocalDateTime

@Repository
interface TermsRepository : JpaRepository<Terms, Long> {

    @Query("SELECT t FROM Terms t WHERE t.status = :status AND t.startedAt <= :now AND t.endedAt >= :now ORDER BY t.sequence ASC")
    fun findActiveTerms(
        @Param("now") now: LocalDateTime,
        @Param("status") status: TermsStatus = TermsStatus.ACTIVE,
    ): List<Terms>
}