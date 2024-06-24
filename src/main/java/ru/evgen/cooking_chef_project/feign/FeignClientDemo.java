package ru.evgen.cooking_chef_project.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "catFact", url = "https://catfact.ninja/fact")
public interface FeignClientDemo {

    @GetMapping()
    String getFact();

}
