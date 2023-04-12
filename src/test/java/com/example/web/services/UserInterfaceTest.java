package com.example.web.services;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.web.json.UserResponse;

@SpringBootTest
public class UserInterfaceTest {
  
  @Autowired
  private UserInterface userInterface;

  @Test
  public void test(){
    List<UserResponse> users = this.userInterface.getUsers();
    assertNotNull(users);
    assertTrue(users.size()==10);
  }
}
