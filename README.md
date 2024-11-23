# socialMedia
這是一個簡易的社群媒體平台，以 Maven 作為專案建立的工具，並使用 Spring Boot 搭配 Vue.js 完成。

將具備以下功能：
1. 註冊功能
2. 登入驗證功能
3. 發文功能
4. 留言功能

## 啟動專案說明
於資料夾根目錄執行指令：
`` mvn clean package ``
將於 /target/ 產生 .jar 檔。

執行指令：
``java -jar target/social-media-0.0.1-SNAPSHOT.jar``

完成後即可訪問 `localhost:8080` 檢視專案。

## 開發日誌
目前已具備以下 API 可供前端使用，Response 還沒有固定的格式。

請參閱 [API 規格文件連結](/src/main/java/com/chiakaitu/social_media/controller/API.md)

註冊 `[POST] /api/users`

登入 `[POST] /api/login`

查詢會員資訊 [`GET] /api/users/{userId}`