package com.example.web.services;

import java.util.List;

import org.springframework.web.service.annotation.GetExchange;

import com.example.web.json.UserResponse;

public interface UserInterface {
  @GetExchange("users")
  public List<UserResponse> getUsers();
}
