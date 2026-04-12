CREATE DATABASE log;

CREATE TABLE IF NOT EXISTS users
(
    id                BIGINT      NOT NULL AUTO_INCREMENT,
    app_user_id       BIGINT      NOT NULL,
    nickname          VARCHAR(32) NOT NULL,
    status            VARCHAR(16) NOT NULL,
    email             VARCHAR(32),
    profile_image_url VARCHAR(512),
    created_at        DATETIME(6) NOT NULL,
    updated_at        DATETIME(6) NOT NULL,
    PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

CREATE TABLE IF NOT EXISTS content
(
    id              BIGINT       NOT NULL AUTO_INCREMENT,
    category_type   VARCHAR(20)  NOT NULL,
    title           VARCHAR(255) NOT NULL,
    description     TEXT,
    cover_image_url VARCHAR(500),
    author          VARCHAR(255),
    publisher       VARCHAR(255),
    isbn            VARCHAR(20),
    director        VARCHAR(255),
    runtime_minutes INT,
    created_at      DATETIME(6)  NOT NULL,
    updated_at      DATETIME(6)  NOT NULL,
    PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

CREATE TABLE IF NOT EXISTS schedule
(
    id         BIGINT      NOT NULL AUTO_INCREMENT,
    content_id BIGINT      NOT NULL,
    started_at DATETIME(6) NOT NULL,
    ended_at   DATETIME(6) NOT NULL,
    status     VARCHAR(10) NOT NULL,
    memo       VARCHAR(200),
    created_at DATETIME(6) NOT NULL,
    updated_at DATETIME(6) NOT NULL,
    PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

CREATE TABLE IF NOT EXISTS review
(
    id            BIGINT      NOT NULL AUTO_INCREMENT,
    user_id       BIGINT      NOT NULL,
    content_id    BIGINT      NOT NULL,
    comment       TEXT,
    short_comment VARCHAR(512),
    rating        TINYINT,
    visible       TINYINT(1)  NOT NULL DEFAULT 1,
    status        VARCHAR(16) NOT NULL DEFAULT 'PUBLISHED',
    created_at    DATETIME(6) NOT NULL,
    updated_at    DATETIME(6) NOT NULL,
    PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

CREATE TABLE IF NOT EXISTS review_question
(
    id         BIGINT       NOT NULL AUTO_INCREMENT,
    review_id  BIGINT       NOT NULL,
    question   VARCHAR(128) NOT NULL,
    sequence   INT          NOT NULL DEFAULT 0,
    created_at DATETIME(6)  NOT NULL,
    updated_at DATETIME(6)  NOT NULL,
    PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

CREATE TABLE IF NOT EXISTS review_answer
(
    id                 BIGINT      NOT NULL AUTO_INCREMENT,
    review_id          BIGINT      NOT NULL,
    review_question_id BIGINT      NOT NULL,
    answer             TEXT        NOT NULL,
    created_at         DATETIME(6) NOT NULL,
    updated_at         DATETIME(6) NOT NULL,
    PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

CREATE TABLE IF NOT EXISTS review_quote
(
    id         BIGINT      NOT NULL AUTO_INCREMENT,
    review_id  BIGINT      NOT NULL,
    quote      TEXT        NOT NULL,
    sequence   INT         NOT NULL DEFAULT 0,
    created_at DATETIME(6) NOT NULL,
    updated_at DATETIME(6) NOT NULL,
    PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

CREATE TABLE IF NOT EXISTS content_like
(
    id         BIGINT      NOT NULL AUTO_INCREMENT,
    user_id    BIGINT      NOT NULL,
    content_id BIGINT      NOT NULL,
    created_at DATETIME(6) NOT NULL,
    updated_at DATETIME(6) NOT NULL,
    PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

CREATE TABLE IF NOT EXISTS terms
(
    id         BIGINT       NOT NULL AUTO_INCREMENT,
    type       VARCHAR(16)  NOT NULL,
    version    INT          NOT NULL,
    content    VARCHAR(128) NOT NULL,
    required   TINYINT(1)   NOT NULL,
    started_at DATETIME(6)  NOT NULL,
    ended_at   DATETIME(6)  NOT NULL,
    sequence   INT          NOT NULL DEFAULT 0,
    status     VARCHAR(16)  NOT NULL DEFAULT 'ACTIVE',
    created_at DATETIME(6)  NOT NULL,
    updated_at DATETIME(6)  NOT NULL,
    PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

CREATE TABLE IF NOT EXISTS terms_agreement
(
    id         BIGINT      NOT NULL AUTO_INCREMENT,
    user_id    BIGINT      NOT NULL,
    terms_id   BIGINT      NOT NULL,
    agreed     TINYINT(1)  NOT NULL,
    created_at DATETIME(6) NOT NULL,
    updated_at DATETIME(6) NOT NULL,
    PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

CREATE TABLE IF NOT EXISTS review_comment
(
    id         BIGINT      NOT NULL AUTO_INCREMENT,
    review_id  BIGINT      NOT NULL,
    user_id    BIGINT      NOT NULL,
    content    TEXT        NOT NULL,
    status     VARCHAR(16) NOT NULL DEFAULT 'ACTIVE',
    created_at DATETIME(6) NOT NULL,
    updated_at DATETIME(6) NOT NULL,
    PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

CREATE TABLE IF NOT EXISTS review_comment_like
(
    id         BIGINT      NOT NULL AUTO_INCREMENT,
    user_id    BIGINT      NOT NULL,
    comment_id BIGINT      NOT NULL,
    created_at DATETIME(6) NOT NULL,
    updated_at DATETIME(6) NOT NULL,
    PRIMARY KEY (id),
    UNIQUE KEY uq_review_comment_like (user_id, comment_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;