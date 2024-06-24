package ru.evgen.cooking_chef_project.test;


import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class AuthorizationExample {

    public static void main(String[] args) {
        // Step 1: Авторизуйтесь во внешней службе и получите JWT

        // Замените их вашими действительными учетными данными для проверки подлинности
        String externalServiceUrl = "https://example.com/auth";
        String username = "your_username";
        String password = "your_password";

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders authHeaders = new HttpHeaders();
        authHeaders.set("Content-Type", "application/json");

        // Создайте объект запроса с аутентификационными данными
        HttpEntity<String> authRequest = new HttpEntity<>("{\"username\":\"" + username + "\",\"password\":\"" + password + "\"}", authHeaders);

        ResponseEntity<String> authResponse = restTemplate.exchange(
                externalServiceUrl,
                HttpMethod.POST,
                authRequest,
                String.class
        );

        if (authResponse.getStatusCode().is2xxSuccessful()) {
            // Предполагая, что JWT возвращается в теле ответа
            String jwt = authResponse.getBody();

            // Step 2: Отправьте запрос в защищенную службу с помощью JWT

            // Замените их фактическими конечными точками и заголовками, требуемыми защищенной службой
            String protectedServiceUrl = "https://api.protectedservice.com/data";

            HttpHeaders protectedHeaders = new HttpHeaders();
            protectedHeaders.set("Authorization", "Bearer " + jwt);
            protectedHeaders.set("Content-Type", "application/json");

            HttpEntity<String> protectedRequest = new HttpEntity<>(protectedHeaders);

            ResponseEntity<String> protectedResponse = restTemplate.exchange(
                    protectedServiceUrl,
                    HttpMethod.GET,
                    protectedRequest,
                    String.class
            );

            if (protectedResponse.getStatusCode().is2xxSuccessful()) {
                String responseData = protectedResponse.getBody();
                System.out.println("Response from the protected service: " + responseData);
            } else {
                System.out.println("Failed to access the protected service");
            }
        } else {
            System.out.println("Failed to obtain JWT");
        }
    }
}

