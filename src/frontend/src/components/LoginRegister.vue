<template>
    <div class="container">
        <div class="form-container">
            <div class="tabs">
                <div :class="{ 'active': activeTab === 'login' }" class="tab" @click="setActiveTab('login')">登入</div>
                <div :class="{ 'active': activeTab === 'register' }" class="tab" @click="setActiveTab('register')">註冊
                </div>
            </div>
            <div class="form-content">
                <!-- 登入表單 -->
                <form v-if="activeTab === 'login'" @submit.prevent="handleLogin">
                    <div class="input-group">
                        <label for="phoneNum">手機號碼</label>
                        <input type="text" id="phoneNum" maxlength="10" v-model="loginForm.phoneNum" required />
                    </div>
                    <div class="input-group">
                        <label for="password">密碼</label>
                        <input type="password" id="password" maxlength="16" v-model="loginForm.password" required />
                    </div>
                    <button type="submit" class="submit-btn">登入</button>
                </form>

                <!-- 註冊表單 -->
                <form v-if="activeTab === 'register'" @submit.prevent="handleRegister">
                    <div class="input-group">
                        <label for="userName">使用者名稱</label>
                        <input type="text" id="userName" maxlength="24" v-model="registerForm.userName" required />
                    </div>
                    <div class="input-group">
                        <label for="phoneNum">手機號碼</label>
                        <input type="text" id="phoneNum" maxlength="10" v-model="registerForm.phoneNum" required />
                    </div>
                    <div class="input-group">
                        <label for="email">電子郵件</label>
                        <input type="email" id="email" maxlength="40" v-model="registerForm.email" required />
                    </div>
                    <div class="input-group">
                        <label for="password">密碼</label>
                        <input type="password" id="password" maxlength="16" v-model="registerForm.password" required />
                    </div>
                    <div class="input-group">
                        <label for="confirmPassword">再次確認密碼</label>
                        <input type="password" id="confirmPassword" maxlength="16"
                            v-model="registerForm.confirmPassword" required />
                    </div>
                    <div v-if="passwordMismatch" class="error">密碼與確認密碼不符！</div>
                    <button type="submit" class="submit-btn" :disabled="passwordMismatch">註冊</button>
                </form>
            </div>
        </div>
    </div>
</template>

<script>
import { ref, computed } from 'vue';
import { httpPostRegister, httpPostLogin } from '@/service/api.service.js'; // 引入 API 函數

export default {
    name: 'LoginRegister',
    setup() {
        // 設定活動頁籤（登入/註冊）
        const activeTab = ref('login');

        // 登入表單資料
        const loginForm = ref({
            phoneNum: '',
            password: ''
        });

        // 註冊表單資料
        const registerForm = ref({
            userName: '',
            phoneNum: '',
            email: '',
            password: '',
            confirmPassword: ''
        });

        // 錯誤訊息
        const errorMessage = ref('');

        // 成功訊息
        const successMessage = ref('');

        // 密碼不符的錯誤提示
        const passwordMismatch = computed(() => {
            return registerForm.value.password !== registerForm.value.confirmPassword;
        });

        // 設定活動頁籤
        const setActiveTab = (tab) => {
            activeTab.value = tab;
            errorMessage.value = ''; // 切換頁籤時清除錯誤訊息
            successMessage.value = '';
            clearFormFields(); // 切換頁籤時清空表單欄位
        };

        // 清空所有表單欄位
        const clearFormFields = () => {
            if (activeTab.value === 'login') {
                loginForm.value = {
                    phoneNum: '',
                    password: ''
                };
            } else if (activeTab.value === 'register') {
                registerForm.value = {
                    userName: '',
                    phoneNum: '',
                    email: '',
                    password: '',
                    confirmPassword: ''
                };
            }
        };

        // 登入處理函式
        const handleLogin = async () => {
            try {
                // 清除舊的訊息
                errorMessage.value = '';
                successMessage.value = '';

                const loginData = {
                    phoneNum: loginForm.value.phoneNum,
                    password: loginForm.value.password
                };

                const response = await httpPostLogin(loginData);
                if (response.result === '0') {
                    successMessage.value = '登入成功！';
                    alert(response.message); // 顯示登入成功訊息
                    clearFormFields(); // 清空表單
                    console.log('登入成功:', response);
                    // 可以在此處導航到其他頁面，例如：router.push('/dashboard')
                } else {
                    errorMessage.value = response.message || '登入失敗，請檢查您的帳號或密碼。';
                    alert(response.message); // 顯示登入失敗訊息
                }
            } catch (error) {
                errorMessage.value = '登入過程中發生錯誤，請稍後再試。';
                alert(error.message); // 顯示錯誤訊息
                console.error('登入錯誤:', error);
            }
        };

        // 註冊處理函式
        const handleRegister = async () => {
            try {
                // 清除舊的訊息
                errorMessage.value = '';
                successMessage.value = '';

                if (passwordMismatch.value) {
                    errorMessage.value = '密碼和確認密碼不一致。';
                    return;
                }

                const registerData = {
                    userName: registerForm.value.userName,
                    phoneNum: registerForm.value.phoneNum,
                    email: registerForm.value.email,
                    password: registerForm.value.password,
                    coverImage: null,
                    biography: null
                };

                const response = await httpPostRegister(registerData);
                if (response.result === '0') {
                    successMessage.value = '註冊成功！請前往登入。';
                    alert(response.message); // 顯示註冊成功訊息
                    // 清空表單
                    clearFormFields();
                    setActiveTab('login'); // 自動切換到登入頁籤
                } else {
                    errorMessage.value = response.message || '註冊失敗，請檢查您的資料。';
                    alert(response.message); // 顯示註冊失敗訊息
                }
            } catch (error) {
                errorMessage.value = '註冊過程中發生錯誤，請稍後再試。';
                alert(error.message); // 顯示錯誤訊息
                console.error('註冊錯誤:', error);
            }
        };

        return {
            activeTab,
            loginForm,
            registerForm,
            errorMessage,
            successMessage,
            passwordMismatch,
            setActiveTab,
            handleLogin,
            handleRegister
        };
    }
};
</script>

<style scoped>
/* 外部背景填滿 */
.container {
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100vh;
    background-color: #f0c9a1;
}

.form-container {
    background-color: white;
    border-radius: 8px;
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
    width: 400px;
    padding: 20px;
}

.tabs {
    display: flex;
    justify-content: space-around;
    margin-bottom: 20px;
}

.tab {
    cursor: pointer;
    font-weight: bold;
    padding: 10px;
    width: 50%;
    text-align: center;
    background-color: #f4f4f4;
    border-radius: 4px;
    transition: background-color 0.3s;
}

.tab.active {
    background-color: #ff6600;
    color: white;
}

.form-content form {
    display: flex;
    flex-direction: column;
}

.input-group {
    display: flex;
    align-items: center;
    margin-bottom: 15px;
}

.input-group label {
    width: 120px;
    font-size: 14px;
    margin-right: 10px;
}

.input-group input {
    flex-grow: 1;
    padding: 10px;
    font-size: 16px;
    border: 1px solid #ccc;
    border-radius: 4px;
}

.submit-btn {
    padding: 10px;
    font-size: 16px;
    background-color: #ff6600;
    color: white;
    border: none;
    border-radius: 4px;
    cursor: pointer;
    transition: background-color 0.3s;
}

.submit-btn:disabled {
    background-color: #ddd;
    cursor: not-allowed;
}

.error {
    color: red;
    font-size: 14px;
    margin-bottom: 10px;
}
</style>
