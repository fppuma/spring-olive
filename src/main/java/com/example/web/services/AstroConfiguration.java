package com.example.web.services;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class AstroConfiguration {
  @Bean
  AstroInterface astroInterface() {
    WebClient client = WebClient.create("http://api.open-notify.org");
    HttpServiceProxyFactory factory =
      HttpServiceProxyFactory.builder(
        WebClientAdapter.forClient(client)
      ).build();
    return factory.createClient(AstroInterface.class);
  }
}
