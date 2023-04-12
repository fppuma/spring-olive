# spring-olive
Spring Web and Rest Clients

## Pojo
This **record** maps the result of the endpoint.
```java
public record AstroResponse(String message, int number, List<Assignment> people) {
  public record Assignment(String craft, String name) {}
}

```
## WebClient
In the constructor.

```java
public AstroService(WebClient.Builder builder){
  this.client = builder.baseUrl("http://api.open-notify.org").build();
}

public AstroResponse getAstroResponse() {
  return client.get()
    .uri("/astros.json")
    .retrieve()
    .bodyToMono(AstroResponse.class)
    .block(Duration.ofSeconds(2));
}
```

Check the unit test.

## Interface
- AstroInterface.java
- AstroConfiguration.java (with a method that implements the interface).

```java
public interface AstroInterface {
  @GetExchange("/astros.json")
  AstroResponse getAstroResponse();
}

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
```

## JsonPlaceHolder Users
- UserResponse.java (record)
- UserInterface.java
- UserConfiguration.java
- UserController.java

```
http://localhost:8080/users
```