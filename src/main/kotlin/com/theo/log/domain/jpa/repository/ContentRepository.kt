package com.theo.log.domain.jpa.repository

import com.theo.log.domain.jpa.entity.Content
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ContentRepository : JpaRepository<Content, Long>
