package com.calendar.sejin.hello;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @PostMapping("/hello")
    public String helloPost(@RequestBody HelloRequest request) {
        return "post:"+request.getName();
    }

    @GetMapping("/hello/{name}")
    public String helloGet(@PathVariable("name") String name) {
        return "get:"+name;
    }
    @PutMapping("/hello/{name}")
    public String helloPut(@PathVariable("name") String name) {
        return "put:"+name;
    }
    @DeleteMapping("/hello/{name}")
    public String helloDelete(@PathVariable("name") String name) {
        return "delete:"+name;
    }
}
