# Feign
>[Подробная инструкция](https://cloud.spring.io/spring-cloud-netflix/multi/multi_spring-cloud-feign.html)


Для использования feign клиента в своем приложении нужно выполнить некоторые условия:
- Подтянуть данную зависимость с API в свое приложение
- Подтянуть зависимости Spring
- Подтянуть зависимости [Feign](https://mvnrepository.com/artifact/org.springframework.cloud/spring-cloud-starter-feign) 

## Пример Spring Boot Application
### Подключение Feign в Spring Boot Application 
```java
@SpringBootApplication
@EnableFeignClients
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
```
### Пример использования клиента
```java
import KafkaServiceClient;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UsageExample() {
    private final KafkaServiceClient serviceClient; // Feign client

    public void sendMessageExample(String topic, String message) {
        serviceClient.sendMessage(topic, message); // Feign client usage
    }
}
```