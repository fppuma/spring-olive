package com.example.web.json;

public record UserResponse(int id, String name, String username, String email,
  String phone, String website, Address address, Company company ) {
  
}
