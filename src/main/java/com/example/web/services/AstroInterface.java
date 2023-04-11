package com.example.web.services;

import org.springframework.web.service.annotation.GetExchange;

import com.example.web.json.AstroResponse;

public interface AstroInterface {
  @GetExchange("/astros.json")
  AstroResponse getAstroResponse();
}
