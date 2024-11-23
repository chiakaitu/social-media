// api.service.js
import axios from 'axios';

// 註冊功能：向後端發送 POST 請求
export const httpPostRegister = async (registerData) => {
  try {
    // 發送 POST 請求到 /api/users 註冊端點
    const response = await axios.post('/api/users', registerData);
    
    // 檢查回應結果
    if (response.data.result === '0') {
      console.log('註冊成功:', response.data.message);
      return response.data; // 成功的情況下返回回應
    } else {
      console.error('註冊失敗:', response.data.message);
      return { result: '1', message: response.data.message }; // 失敗的情況下返回錯誤訊息
    }
  } catch (error) {
    console.error('註冊過程中發生錯誤:', error);
    return { result: '1', message: '註冊過程中發生錯誤' }; // 發生錯誤時返回錯誤訊息
  }
};

// 登入功能：向後端發送 POST 請求
export const httpPostLogin = async (loginData) => {
  try {
    // 發送 POST 請求到 /api/login 登入端點
    const response = await axios.post('/api/login', loginData);

    // 檢查回應結果
    if (response.data.result === '0') {
      console.log('登入成功:', response.data.message);
      return response.data; // 成功的情況下返回回應
    } else {
      console.error('登入失敗:', response.data.message);
      return { result: '1', message: response.data.message }; // 失敗的情況下返回錯誤訊息
    }
  } catch (error) {
    console.error('登入過程中發生錯誤:', error);
    return { result: '1', message: '登入過程中發生錯誤' }; // 發生錯誤時返回錯誤訊息
  }
};
