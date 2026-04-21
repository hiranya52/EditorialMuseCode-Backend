package edu.icet.controller;


import edu.icet.model.entity.AuthRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import edu.icet.service.AuthService;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService service;

    @GetMapping
    private String test(){
        return "MuseCode Loaded....";
    }

    @PostMapping("/login")
    public String login(@RequestBody AuthRequest request) {
        return service.login(request.getUsername(), request.getPassword());
    }

}
