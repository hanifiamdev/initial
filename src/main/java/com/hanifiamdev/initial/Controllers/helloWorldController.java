package com.hanifiamdev.initial.Controllers;

import org.springframework.web.bind.annotation.*;

@RestController
public class helloWorldController {

    @GetMapping("/Helloworld")
    public String Helloworld() {
        return "Hello world!";
    }

    @GetMapping("/Helloworld/{name}")
    public String HelloworldName(@PathVariable(value = "name") String name) {
        return "hello " + name;
    }

    @PostMapping("/Helloworld")
    public String HelloworldPostController(@RequestParam(name = "Username") String username) {
        return "hello " + username;
    }
}
