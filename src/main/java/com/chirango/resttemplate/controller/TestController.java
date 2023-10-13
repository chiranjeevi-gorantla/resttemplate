package com.chirango.resttemplate.controller;

import com.chirango.resttemplate.dto.UserResponse;
import com.chirango.resttemplate.model.User;
import com.chirango.resttemplate.service.TestService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class TestController {

    private final TestService testService;

    @GetMapping("/user/{id}")
    @ResponseBody
    public ResponseEntity<UserResponse> getUser(@PathVariable Long id) {
        String url = "https://jsonplaceholder.typicode.com/users/" + id;
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<User> response = restTemplate.getForEntity(url, User.class);

        User user = response.getBody();

        return ResponseEntity.status(HttpStatus.OK).body(testService.getUser(user));
    }
}

