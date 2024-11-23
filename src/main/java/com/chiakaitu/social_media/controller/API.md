# API 規格：

- [API 規格：](#api-規格)
  - [\[POST\] /api/users](#post-apiusers)
    - [Request Body](#request-body)
    - [Response Body](#response-body)
    - [範例](#範例)
  - [\[GET\] /api/users/{userId}](#get-apiusersuserid)
    - [Request](#request)
    - [Response Body](#response-body-1)
    - [範例](#範例-1)
  - [\[GET\] /api/users/{userId}/posts](#get-apiusersuseridposts)
    - [Request](#request-1)
    - [Response Body](#response-body-2)
    - [範例](#範例-2)
  - [\[POST\] /api/login](#post-apilogin)
    - [Request Body](#request-body-1)
    - [Response Body](#response-body-3)
    - [範例](#範例-3)
  - [\[POST\] /api/posts](#post-apiposts)
    - [Request Body](#request-body-2)
    - [Response Body](#response-body-4)
    - [範例](#範例-4)


## [POST] /api/users

### Request Body

| 欄位名稱     | 型別     | 描述                         | 範例                | 是否必填 |
|--------------|----------|------------------------------|---------------------|----------|
| `userName`   | `String` | 使用者名稱，通常為暱稱或真實姓名 | `"Zac"`             | 是       |
| `phoneNum`   | `String` | 使用者手機號碼               | `"0999999999"`      | 是       |
| `email`      | `String` | 使用者電子郵件地址           | `"zac@example.com"` | 是       |
| `password`   | `String` | 使用者密碼（已Hash處理）     | `"hashed_password3"`| 是       |
| `coverImage` | `String` | 使用者封面圖片的 URL（可為 `null`） | `null`            | 否       |
| `biography`  | `String` | 使用者簡介（簡短的自我介紹）  | `"I am Zac."`       | 否       |

### Response Body

| 欄位名稱  | 型別    | 描述                                | 範例        |
|-----------|---------|-------------------------------------|-------------|
| `result`  | `String`| 操作結果代碼，`0` 為成功，`1` 為失敗   | `"0"`       |
| `message` | `String`| 操作結果的訊息描述                  | `"success"` |

### 範例
#### Request 範例
```json
{
    "userName": "Zac",
    "phoneNum": "0999999999",
    "email": "zac@example.com",
    "password": "hashed_password3",
    "coverImage": null,
    "biography": "I am Zac."
}
```
#### Response 範例
```json
{
    "result": "0",
    "message": "success"
}
```

---

## [GET] /api/users/{userId}

### Request

| 欄位名稱  | 型別    | 描述                          | 範例  | 是否必填 |
|-----------|---------|-------------------------------|-------|----------|
| `userId`  | `Integer`| 使用者的唯一識別碼（路徑參數）   | `2`   | 是       |

### Response Body

| 欄位名稱   | 型別     | 描述                           | 範例               |
|------------|----------|--------------------------------|--------------------|
| `userId`   | `Integer`| 使用者的唯一識別碼             | `2`                |
| `userName` | `String` | 使用者名稱，通常為暱稱或真實姓名 | `"Bob"`            |
| `phoneNum` | `String` | 使用者手機號碼                 | `"0912345678"`     |
| `email`    | `String` | 使用者電子郵件地址             | `"bob@example.com"`|
| `password` | `String` | 使用者密碼（已Hash處理）       | `"hashed_password2"`|
| `coverImage`| `String`| 使用者封面圖片的 URL（可為 `null`） | `null`          |
| `biography`| `String` | 使用者簡介（簡短的自我介紹）   | `"I am Bob."`      |

### 範例
#### Response 範例
```json
{
    "userId": 2,
    "userName": "Bob",
    "phoneNum": "0912345678",
    "email": "bob@example.com",
    "password": "hashed_password2",
    "coverImage": null,
    "biography": "I am Bob."
}
```

---

## [GET] /api/users/{userId}/posts

### Request

| 欄位名稱  | 型別    | 描述                         | 範例  | 是否必填 |
|-----------|---------|------------------------------|-------|----------|
| `userId`  | `Integer`| 使用者的唯一識別碼（路徑參數） | `2`   | 是       |

### Response Body

| 欄位名稱  | 型別          | 描述                              | 範例                |
|-----------|---------------|-----------------------------------|---------------------|
| `result`  | `String`      | 操作結果代碼，`0` 為成功，`1` 為失敗   | `"0"`              |
| `message` | `String`      | 操作結果的訊息描述                  | `"success"`         |
| `details` | `List<Object>`| 包含貼文的列表，若無貼文則為空陣列     | `[ ... ]`          |

`details` 結構：

| 欄位名稱    | 型別      | 描述              | 範例                      |
|-------------|-----------|-------------------|---------------------------|
| `userId`    | `Integer` | 發布貼文的使用者 ID | `2`                        |
| `content`   | `String`  | 貼文內容          | `"這是一則貼文內容。"`     |
| `image`     | `String`  | 圖片的 URL，若無則為 `null` | `null`                   |
| `createdAt` | `String`  | 貼文建立的時間    | `"2024-11-23 10:30:00"`    |

### 範例
#### Response 範例
```json
{
    "result": "0",
    "message": "success",
    "details": [
        {
            "userId": 2,
            "content": "這是一則貼文內容。",
            "image": "https://example.com/image.jpg",
            "createdAt": "2024-11-23 10:30:00"
        },
        {
            "userId": 2,
            "content": "另一則貼文內容。",
            "image": null,
            "createdAt": "2024-11-22 15:45:00"
        }
    ]
}
```

---

## [POST] /api/login

### Request Body

| 欄位名稱  | 型別     | 描述                       | 範例                | 是否必填 |
|-----------|----------|----------------------------|---------------------|----------|
| `phoneNum`| `String` | 使用者手機號碼             | `"0999999999"`      | 是       |
| `password`| `String` | 使用者密碼（已Hash處理）   | `"hashed_password3"`| 是       |

### Response Body

| 欄位名稱  | 型別    | 描述                                | 範例        |
|-----------|---------|-------------------------------------|-------------|
| `result`  | `String`| 操作結果代碼，`0` 為成功，`1` 為失敗   | `"0"`       |
| `message` | `String`| 操作結果的訊息描述                  | `"success"` |

### 範例
#### Response 範例
```json
{
    "phoneNum": "0999999999",
    "password": "hashed_password3"
}
```

---

## [POST] /api/posts

### Request Body

| 欄位名稱   | 型別     | 描述                       | 範例                      | 是否必填 |
|------------|----------|----------------------------|---------------------------|----------|
| `userId`   | `Integer`| 發布貼文的使用者 ID        | `4`                        | 是       |
| `content`  | `String` | 貼文內容                   | `"這是一則貼文內容"`        | 是       |
| `image`    | `String` | 圖片的 URL，若無則為 `null` | `null`                     | 否       |

### Response Body

| 欄位名稱  | 型別    | 描述                                | 範例        |
|-----------|---------|-------------------------------------|-------------|
| `result`  | `String`| 操作結果代碼，`0` 為成功，`1` 為失敗   | `"0"`       |
| `message` | `String`| 操作結果的訊息描述                  | `"success"` |

### 範例
#### Request 範例
```json
{
    "userId": 4,
    "content": "這是一則貼文內容",
    "image": "https://example.com/image.jpg"
}
```
---
