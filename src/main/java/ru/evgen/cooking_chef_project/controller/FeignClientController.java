package ru.evgen.cooking_chef_project.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.evgen.cooking_chef_project.feign.FeignClientDemo;

@RestController
@RequestMapping("/cat'sFact")
@RequiredArgsConstructor
public class FeignClientController {

    private final FeignClientDemo feignClientDemo;

    @GetMapping("/getFact")
    public String getFact(){
       return feignClientDemo.getFact();
    }
    
}
