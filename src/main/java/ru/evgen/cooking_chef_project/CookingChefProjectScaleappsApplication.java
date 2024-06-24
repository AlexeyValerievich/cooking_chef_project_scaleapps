package ru.evgen.cooking_chef_project;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import java.util.logging.Logger;

@SpringBootApplication
@EnableFeignClients
public class CookingChefProjectScaleappsApplication {

    public static void main(String[] args) {

        SpringApplication.run(CookingChefProjectScaleappsApplication.class, args);
    }

}
