package com.myfirstapp.myfirstspringapp.controller;

import com.myfirstapp.myfirstspringapp.model.User;
import org.springframework.web.bind.annotation.*;

@RestController
//curl "http://localhost:8080/hello" -w "\n"
//curl "http://localhost:8080/hello/home" -w "\n"
@RequestMapping("/hello")
public class HelloWorldController {
    @RequestMapping(value = {"", "/", "/home"})
    public String sayHello() {
        return "Hello World!";
    }

    //curl -X GET "http://localhost:8080/hello/query/?fName=Rajesh&lName=Pal" -w "\n"
    @RequestMapping(value = {"/query"}, method = RequestMethod.GET)
    public String sayHello(@RequestParam(value = "fName") String fName, @RequestParam(value = "lName") String lName) {
        return "Hello " + fName + " " + lName + " !";
    }

    //curl -X GET "http://localhost:8080/hello/param/Rajesh" -w "\n"
    @GetMapping("/param/{name}")
    public String sayHelloParam(@PathVariable String name) {
        return "Hello " + name + " !";
    }

    @PostMapping("/post")
    public String sayHello(@RequestBody User user) {
        return "Hello " + user.getFirstName() + " " + user.getLastName() + " !";
    }

    //curl -X PUT "http://localhost:8080/hello/put/Rajesh?lastName=Pal" -w "\n"
    @PutMapping("/put/{firstName}")
    public String sayHelloPut(@PathVariable String firstName, @RequestParam(value = "lastName") String lastName) {
        return "Hello " + firstName + " " + lastName + " !";
    }



}
