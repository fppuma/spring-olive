package com.example.web.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.web.json.UserResponse;
import com.example.web.services.UserInterface;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class UserController {
  private UserInterface userInterface;

  @GetMapping("users")
  public List<UserResponse> getUsers() {
    return this.userInterface.getUsers();
  }

}
