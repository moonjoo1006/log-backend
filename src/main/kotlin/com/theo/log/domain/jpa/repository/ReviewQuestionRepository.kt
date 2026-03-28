package com.theo.log.domain.jpa.repository

import com.theo.log.domain.jpa.entity.ReviewQuestion
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ReviewQuestionRepository : JpaRepository<ReviewQuestion, Long>
