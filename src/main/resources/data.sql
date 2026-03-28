-- users
INSERT INTO users (app_user_id, nickname, status, email, profile_image_url, created_at, updated_at) VALUES
(1001, '테오', 'JOIN', 'theo@example.com', 'https://example.com/profile/theo.jpg', NOW(), NOW()),
(1002, '라라', 'JOIN', 'lara@example.com', 'https://example.com/profile/lara.jpg', NOW(), NOW()),
(1003, '민준', 'WITHDRAW', 'minjun@example.com', NULL, NOW(), NOW());

-- content
INSERT INTO content (category_type, title, description, cover_image_url, author, publisher, isbn, director, runtime_minutes, created_at, updated_at) VALUES
('BOOK', '사피엔스',       '인류의 역사를 새로운 시각으로 조명한 책',          'https://image.yes24.com/goods/257435/XL', '유발 하라리', '김영사', '9788934972464', NULL, NULL, NOW(), NOW()),
('BOOK', '아몬드',         '감정을 느끼지 못하는 소년의 성장 이야기',          'https://image.yes24.com/goods/257435/XL', '손원평',      '창비',   '9788936434588', NULL, NULL, NOW(), NOW()),
('BOOK', '채식주의자',     '한 여성의 채식 선언으로 시작되는 이야기',          'https://image.yes24.com/goods/257435/XL', '한강',        '창비',   '9788936434519', NULL, NULL, NOW(), NOW()),
('BOOK', '82년생 김지영',  '한 여성의 평범한 일상을 통해 바라본 사회 구조',    'https://image.yes24.com/goods/257435/XL', '조남주',      '민음사', '9788937473135', NULL, NULL, NOW(), NOW()),
('BOOK', '소년이 온다',    '1980년 5월 광주의 이야기',                         'https://image.yes24.com/goods/257435/XL', '한강',        '창비',   '9788936434632', NULL, NULL, NOW(), NOW()),
('BOOK', '데미안',         '자신을 찾아가는 한 소년의 내면 성장 이야기',       'https://image.yes24.com/goods/257435/XL', '헤르만 헤세', '민음사', '9788937460449', NULL, NULL, NOW(), NOW()),
('BOOK', '어린 왕자',      '사막에 불시착한 조종사와 어린 왕자의 만남',        'https://image.yes24.com/goods/257435/XL', '생텍쥐페리',  '민음사', '9788937460203', NULL, NULL, NOW(), NOW()),
('BOOK', '나미야 잡화점의 기적', '낡은 잡화점 우편함을 통해 이어지는 인연들', 'https://image.yes24.com/goods/257435/XL', '히가시노 게이고', '현대문학', '9788972756128', NULL, NULL, NOW(), NOW()),
('BOOK', '죄와 벌',        '살인을 저지른 청년의 죄책감과 구원의 이야기',      'https://image.yes24.com/goods/257435/XL', '도스토옙스키', '민음사', '9788937460067', NULL, NULL, NOW(), NOW()),
('BOOK', '총균쇠',         '문명의 불평등한 발전을 탐구한 역작',               'https://image.yes24.com/goods/257435/XL', '재레드 다이아몬드', '김영사', '9788934970064', NULL, NULL, NOW(), NOW());

-- schedule
INSERT INTO schedule (content_id, started_at, ended_at, status, memo, created_at, updated_at) VALUES
(1, '2026-03-01 00:00:00', '2026-03-31 23:59:59', 'ON',  '3월 필독서',  NOW(), NOW()),
(2, '2026-04-01 00:00:00', '2026-04-30 23:59:59', 'ON',  '4월 필독서',  NOW(), NOW()),
(3, '2026-02-01 00:00:00', '2026-02-28 23:59:59', 'OFF', '2월 완료',    NOW(), NOW());

-- review
INSERT INTO review (user_id, content_id, comment, short_comment, rating, public, status, created_at, updated_at) VALUES
(1, 1, '인류의 역사를 이렇게 쉽고 흥미롭게 풀어낼 수 있다니 놀랍다. 강력 추천.', '역사를 보는 눈이 달라졌다',        5,    1, 'PUBLISHED', NOW(), NOW()),
(2, 1, '방대한 내용이지만 술술 읽힌다. 다만 후반부가 조금 아쉬웠다.',              '흥미롭지만 후반부는 다소 아쉬움', 4,    1, 'PUBLISHED', NOW(), NOW()),
(1, 2, '감정이 없는 주인공의 시선으로 세상을 바라보는 경험이 신선했다.',           '조용하지만 묵직한 울림',          5,    1, 'PUBLISHED', NOW(), NOW()),
(2, 3, '한강 작가 특유의 문체가 인상적이었다. 읽는 내내 불편하지만 멈출 수 없었다.', '불편하지만 강렬한 작품',        4,    0, 'PUBLISHED', NOW(), NOW()),
(1, 4, '김지영의 이야기가 남의 이야기 같지 않았다. 주변에서 흔히 볼 수 있는 일들이라 더 씁쓸했다.', '공감되지만 씁쓸한 책', 4, 1, 'DRAFT', NOW(), NOW()),
(2, 5, '읽는 내내 마음이 무거웠다. 역사의 아픔을 이렇게 섬세하게 담아낼 수 있다는 게 놀랍다.',    '무겁고 아프지만 꼭 읽어야 할 책', 5, 1, 'DRAFT', NOW(), NOW()),
(1, 6, '어릴 때 읽었을 때와는 전혀 다르게 다가왔다. 자아를 찾는 과정이 지금의 나와 겹쳤다.',      '다시 읽길 잘했다', 5, 1, 'DRAFT', NOW(), NOW()),
(2, 7, '단순한 동화인 줄 알았는데 읽을수록 깊은 의미가 숨어 있었다. 어른을 위한 동화.',           '어른이 읽어야 할 동화', 4, 1, 'DRAFT', NOW(), NOW());

-- review_question
INSERT INTO review_question (review_id, question, sequence, created_at, updated_at) VALUES
(1, '이 책에서 가장 인상 깊었던 부분은?', 0, NOW(), NOW()),
(1, '다음에 읽고 싶은 책이 생겼나요?', 1, NOW(), NOW()),
(3, '주인공에게 공감했던 순간은?', 0, NOW(), NOW());

-- review_answer
INSERT INTO review_answer (review_id, review_question_id, answer, created_at, updated_at) VALUES
(1, 1, '인지혁명 파트에서 언어가 인류를 어떻게 변화시켰는지 설명하는 부분이 특히 좋았다.', NOW(), NOW()),
(1, 2, '총균쇠를 바로 구매했다.', NOW(), NOW()),
(3, 3, '감정을 표현하지 못해 오해받는 장면에서 많이 공감했다.', NOW(), NOW());

-- review_quote
INSERT INTO review_quote (review_id, quote, sequence, created_at, updated_at) VALUES
(1, '역사는 승자의 것이 아니라 이야기하는 자의 것이다.', 0, NOW(), NOW()),
(3, '나는 괜찮다고 말했지만, 아무도 믿지 않았다.', 0, NOW(), NOW()),
(3, '감정이 없다는 건, 아무것도 느끼지 못한다는 게 아니었다.', 1, NOW(), NOW());

-- content_like
INSERT INTO content_like (user_id, content_id, created_at, updated_at) VALUES
(1, 2, NOW(), NOW()),
(1, 3, NOW(), NOW()),
(2, 1, NOW(), NOW()),
(2, 2, NOW(), NOW());

-- terms
INSERT INTO terms (type, version, content, required, started_at, ended_at, sequence, status, created_at, updated_at) VALUES
('AGE',     1, '만 14세 이상 회원만 가입할 수 있습니다.',                 1, '2026-01-01 00:00:00', '2099-12-31 23:59:59', 0, 'ACTIVE', NOW(), NOW()),
('PRIVACY', 1, '개인정보 수집 및 이용에 동의합니다.',                    1, '2026-01-01 00:00:00', '2099-12-31 23:59:59', 1, 'ACTIVE', NOW(), NOW()),
('SERVICE', 1, '서비스 이용약관에 동의합니다.',                          1, '2026-01-01 00:00:00', '2099-12-31 23:59:59', 2, 'ACTIVE', NOW(), NOW());

-- terms_agreement
INSERT INTO terms_agreement (user_id, terms_id, agreed, created_at, updated_at) VALUES
(1, 1, 1, NOW(), NOW()),
(1, 2, 1, NOW(), NOW()),
(1, 3, 1, NOW(), NOW()),
(2, 1, 1, NOW(), NOW()),
(2, 2, 1, NOW(), NOW()),
(2, 3, 1, NOW(), NOW());