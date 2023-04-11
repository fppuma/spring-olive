package com.example.web.services;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AstroServiceTest {
  @Autowired
  private AstroService service;

  @Test
  void getPeople() {
    String people = service.getPeople();
    assertNotNull(people);
  }

  @Test
  void getAStroResponse() {
    var response = service.getAstroResponse();
    assertNotNull(response);
    assertAll(
      () -> assertNotNull(response.message()),
      () -> assertTrue(response.number() >= 0),
      () -> assertEquals(response.number(), response.people().size())
    );
  }
}
