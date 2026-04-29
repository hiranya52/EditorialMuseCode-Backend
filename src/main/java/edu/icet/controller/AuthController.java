package edu.icet.controller;


import edu.icet.model.dto.LoginRequest;
import edu.icet.model.dto.RegisterRequest;
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

//    @PostMapping("/register")
//    public String register(@RequestBody AuthRequest request) {
//        return service.register(request.getUsername(), request.getPassword());
//    }
//
//    @PostMapping("/login")
//    public String login(@RequestBody AuthRequest request) {
//        return service.login(request.getUsername(), request.getPassword());
//    }


    @PostMapping("/register")
    public String register(@RequestBody RegisterRequest request) {
        return service.register(
                request.getFullName(),
                request.getEmail(),
                request.getPassword()
        );
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest request) {
        return service.login(
                request.getEmail(),
                request.getPassword()
        );
    }

}
