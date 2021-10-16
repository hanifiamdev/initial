package com.hanifiamdev.initial.Controllers;

import com.hanifiamdev.initial.Entity.Todo;
import com.hanifiamdev.initial.Entity.Username;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;
import java.util.Arrays;

@RestController
public class helloWorldController {

    RestTemplate restTemplate = new RestTemplate();

    @GetMapping("/todo/get")
    public String getTodo() {
        String result = restTemplate.getForObject("https://jsonplaceholder.typicode.com/todos", String.class);
        return result;
    }

    @GetMapping("todo/post")
    public String postTodo() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        Todo newTodo = new Todo();
        newTodo.setId((long) 1000);
        newTodo.setTitle("Joe");
        newTodo.setUserId((long) 9);
        newTodo.setCompleted(false);

        HttpEntity<Todo> entity = new HttpEntity<Todo> (newTodo, headers);

        return restTemplate.exchange("https://jsonplaceholder.typicode.com/todos", HttpMethod.POST, entity, String.class).getBody();

    }

    @GetMapping("/todo/delete")
    public String deleteTodo() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        Todo newTodo = new Todo();
        newTodo.setId((long) 1);

        HttpEntity<Todo> entity = new HttpEntity<Todo> (newTodo, headers);

        return restTemplate.exchange("https://jsonplaceholder.typicode.com/todos/" + newTodo.getId(), HttpMethod.DELETE, entity, String.class).getBody();

    }

    @GetMapping("/todo/put/{id}")
    public String updateTodo(@PathVariable("id") String id) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        Todo updateTodo = new Todo();
        updateTodo.setTitle("John Wick");
        updateTodo.setCompleted(true);

        HttpEntity<Todo> entity = new HttpEntity<Todo>(updateTodo, headers);

        return restTemplate.exchange("https://jsonplaceholder.typicode.com/todos/" + id, HttpMethod.PUT, entity, String.class).getBody();

    }

   /* @GetMapping("/Helloworld")
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

    @PostMapping("/HelloworldUser")
    public Username HelloWordUserPostController(@Valid @RequestBody Username username) {
        return username;
    } */

}