package com.revature.service;

import com.revature.model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

public class UserServiceUnitTest {
    List<User> mockList = Mockito.mock(List.class);

    @Test
    public void whenGivenUserObjectCreateNewObjectAddsToList(){
        User user = new User();
        UserService userService = new UserService();

        Assertions.assertDoesNotThrow(()->userService.createUser(user));
    }

    @Test
    public void whenGivenUserObjectCreateNewObjectReturnsTrue(){
        User user = new User();
        UserService userService = new UserService(mockList);
        Mockito.when(mockList.add(user)).thenReturn(true);

        boolean result1 = userService.createUser(user);
        Assertions.assertTrue(result1);
    }

    @Test
    public void whenGetAllUsersIsCalledReturnsListOfUsers() {

        UserService userService = new UserService();
        Assertions.assertDoesNotThrow(()-> userService.getAllUsers());
    }

    @Test
    public void whenGivenValidIdGetUserByIdReturnsUserWithThatId(){
        User user = new User(0, "name1", "redse");

        Mockito.when(mockList.size()).thenReturn(1);
        Mockito.when(mockList.get(0)).thenReturn(user);
        UserService userService = new UserService(mockList);
        User result = userService.getUserById(0);

        Assertions.assertEquals(user, result);
    }
}
