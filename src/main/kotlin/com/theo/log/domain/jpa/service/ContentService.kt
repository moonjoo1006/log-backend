package com.theo.log.domain.jpa.service

import com.theo.log.domain.jpa.repository.ContentRepository
import org.springframework.stereotype.Service

@Service
class ContentService(val contentRepository: ContentRepository) {

}
