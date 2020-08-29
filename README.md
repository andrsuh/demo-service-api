# Feign
>[Подробная инструкция](https://github.com/OpenFeign/feign)

Для использования feign клиента в своем приложении нужно:
- Подтянуть зависимость на это API в свое приложение
- Должна быть явная или неявная зависимость на `spring-boot-starter-web`
- Проследить, что бин `KafkaServiceClient` создается (если Spring его не обрабатывает, то указать явно с помощью `@ComponentScan`)

## Пример Spring Boot Application
### Подключение Feign в Spring Boot Application 
```java

@SpringBootApplication
@ComponentScan("com.wine.to.up") //пакет, который содержит DemoFeignConfiguration c объявлением KafkaServiceClient
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
```
### Пример использования клиента
```java
public class UsageExample() {
    private final KafkaServiceClient serviceClient; // Feign client
    
    public UsageExample(KafkaServiceClient serviceClient) {
        this.serviceClient = serviceClient;
    }

    public void sendMessageExample(String message) {
        serviceClient.sendMessage(message); // Feign client usage
    }
}
```