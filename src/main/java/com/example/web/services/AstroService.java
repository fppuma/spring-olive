package com.example.web.services;

import java.time.Duration;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.web.json.AstroResponse;

@Service
public class AstroService {
  private final WebClient client;

  public AstroService(WebClient.Builder builder){
    this.client = builder.baseUrl("http://api.open-notify.org").build();
  }

  public String getPeople() {
    return client.get()
      .uri("/astros.json")
      .retrieve()
      .bodyToMono(String.class)
      .block(Duration.ofSeconds(2));
  }

  public AstroResponse getAstroResponse() {
    return client.get()
      .uri("/astros.json")
      .retrieve()
      .bodyToMono(AstroResponse.class)
      .block(Duration.ofSeconds(2));
  }
}
