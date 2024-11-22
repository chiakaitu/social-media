-- 切換到該資料庫
USE social_media_platform;

-- 插入範例用戶
INSERT INTO User (user_name, email, password_hash, salt, cover_image, biography)
VALUES
    ('Alice', 'alice@example.com', 'hashed_password1', 'random_salt1', NULL, 'Hi, I am Alice!'),
    ('Bob', 'bob@example.com', 'hashed_password2', 'random_salt2', NULL, 'I am Bob.');

-- 插入範例發文
INSERT INTO Post (user_id, content, image)
VALUES
    (1, 'This is Alice\'s first post!', NULL),
    (2, 'Bob\'s thoughts for today.', NULL);

-- 插入範例留言
INSERT INTO Comment (user_id, post_id, content)
VALUES
    (2, 1, 'Great post, Alice!'),
    (1, 2, 'Thanks for sharing, Bob!');