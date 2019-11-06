package com.demo.graphql.controller;

import com.demo.graphql.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    private UserService userService;

    @Autowired
    public Controller(final UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/rest-accounts")
    public ResponseEntity getAccounts(@RequestParam final int numberOfAccounts) {
        return ResponseEntity.ok().body(userService.getUserForRest(numberOfAccounts));
    }
}
