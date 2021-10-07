package com.hanifiamdev.initial.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class helloWorldController {

    @GetMapping("/Helloworld")
    public  String Helloworld(){
        return "Hello world!";
    }
}
