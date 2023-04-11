package com.example.web.json;
import java.util.List;

public record AstroResponse(String message, int number, List<Assignment> people) {
  public record Assignment(String craft, String name) {}
}
