# CLAUDE.md

## Commands

```bash
./gradlew build          # Compile and run all tests
./gradlew test           # Run tests only
./gradlew bootRun        # Start the application
./gradlew clean          # Clean build artifacts
```
## Architecture

Spring Boot 4.0.4 Kotlin application. Java 21 required.

**Stack:**
- Spring Web MVC
- Spring Data JPA / Hibernate for persistence
- Jackson Kotlin module for JSON serialization

**Structure:** 
- application: 화면에서 전달받은 데이터나, 전달할 데이터를 처리하는 레이어
- controller: API endpoint 레이어
- domain: 서비스 관련 도메인 로직을 포함하는 레이어