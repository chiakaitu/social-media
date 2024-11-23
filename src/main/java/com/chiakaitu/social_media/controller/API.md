# API 規格：
## `[POST] /api/users`

#### Request Body

| 欄位名稱      | 型別        | 描述                              | 範例                 | 是否必填  |
|---------------|-------------|-----------------------------------|----------------------|-----------|
| `userName`    | `String`    | 使用者名稱，通常為暱稱或真實姓名   | `"Zac"`              | 是        |
| `phoneNum`    | `String`    | 使用者手機號碼                    | `"0999999999"`       | 是        |
| `email`       | `String`    | 使用者電子郵件地址                | `"zac@example.com"`  | 是        |
| `password`    | `String`    | 使用者密碼（已hash處理）          | `"hashed_password3"` | 是        |
| `coverImage`  | `String`    | 使用者封面圖片的 URL（可為 `null`） | `null`               | 否        |
| `biography`   | `String`    | 使用者簡介（簡短的自我介紹）      | `"I am Zac."`        | 否        |

#### Response Body

| 欄位名稱   | 型別      | 描述                         | 範例             |
|------------|-----------|------------------------------|------------------|
| `result`   | `String`  | 操作結果代碼，`0` 為成功，`1` 為失敗 | `"0"`            |
| `message`  | `String`  | 操作結果的訊息描述            | `"success"`      |

---

### 範例

#### Request 範例：

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


## `[POST] /api/login`

#### Request Body

| 欄位名稱    | 型別      | 描述                        | 範例                | 是否必填  |
|-------------|-----------|-----------------------------|---------------------|-----------|
| `phoneNum`  | `String`  | 使用者手機號碼              | `"0999999999"`      | 是        |
| `password`  | `String`  | 使用者密碼（已哈希處理）    | `"hashed_password3"`| 是        |

#### Response Body

| 欄位名稱   | 型別      | 描述                         | 範例             |
|------------|-----------|------------------------------|------------------|
| `result`   | `String`  | 操作結果代碼，`0` 為成功，`1` 為失敗 | `"0"`            |
| `message`  | `String`  | 操作結果的訊息描述            | `"success"`      |

---

### 範例

#### Request 範例：

```json
{
    "phoneNum": "0999999999",
    "password": "hashed_password3"
}
```

## `[GET] /api/users/{userId}`

#### Request

| 欄位名稱  | 型別      | 描述                     | 範例                | 是否必填  |
|-----------|-----------|--------------------------|---------------------|-----------|
| `userId`  | `Integer`    | 使用者的唯一識別碼，路徑參數 | 2                 | 是        |

#### Response Body

| 欄位名稱    | 型別      | 描述                            | 範例                |
|-------------|-----------|---------------------------------|---------------------|
| `userId`    | `Integer`    | 使用者的唯一識別碼               | 2                 |
| `userName`  | `String`  | 使用者名稱，通常為暱稱或真實姓名 | `"Bob"`             |
| `phoneNum`  | `String`  | 使用者手機號碼                   | `"0912345678"`      |
| `email`     | `String`  | 使用者電子郵件地址               | `"bob@example.com"` |
| `password`  | `String`  | 使用者密碼（已哈希處理）         | `"hashed_password2"`|
| `coverImage`| `String`  | 使用者封面圖片的 URL（可為 `null`）| `null`              |
| `biography` | `String`  | 使用者簡介（簡短的自我介紹）     | `"I am Bob."`       |

---

### 範例

#### Request 範例：

請求的 URL 是 `/api/users/2`，其中 `userId` 是 URL 路徑參數。

#### Response 範例：

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


