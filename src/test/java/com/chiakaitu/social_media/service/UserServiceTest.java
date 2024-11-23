// package com.chiakaitu.social_media.service;

// import java.util.Optional;

// import static org.junit.jupiter.api.Assertions.assertEquals;
// import static org.junit.jupiter.api.Assertions.assertTrue;
// import org.junit.jupiter.api.Test;
// import org.junit.jupiter.api.extension.ExtendWith;
// import static org.mockito.ArgumentMatchers.eq;
// import org.mockito.InjectMocks;
// import org.mockito.Mock;
// import static org.mockito.Mockito.times;
// import static org.mockito.Mockito.verify;
// import static org.mockito.Mockito.when;
// import org.mockito.junit.jupiter.MockitoExtension;
// import org.springframework.boot.test.context.SpringBootTest;

// import com.chiakaitu.social_media.dao.UserDAO;
// import com.chiakaitu.social_media.entity.User;
// import com.chiakaitu.social_media.service.impl.UserServiceImpl;

// @SpringBootTest
// @ExtendWith(MockitoExtension.class)
// class UserServiceTest {

//     @Mock
//     private UserDAO userDAO;

//     @InjectMocks
//     private UserServiceImpl userService;

//     @Test
//     void testGetUserById() {
//         // 準備測試數據
//         User mockUser = new User();
//         mockUser.setUserId(1);
//         mockUser.setUserName("TestUser");

//         // 模擬 DAO 層行為
//         when(userDAO.findById(eq(1))).thenReturn(Optional.of(mockUser));

//         // 執行測試
//         Optional<User> result = userService.findUserById(1);

//         // 新增調試資訊
//         System.out.println("Mock return value: " + userDAO.findById(1));
//         System.out.println("Actual result: " + result);

//         // 驗證結果
//         assertTrue(result.isPresent(), "使用者應該存在");
//         assertEquals("TestUser", result.get().getUserName(), "使用者名稱應該匹配");
        
//         // 驗證交互
//         verify(userDAO, times(1)).findById(1);
//     }
// }