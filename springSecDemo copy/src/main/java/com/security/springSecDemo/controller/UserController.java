package com.security.springSecDemo.controller;


import com.security.springSecDemo.dto.UserDto;
import com.security.springSecDemo.jwt.JwtService;
import com.security.springSecDemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserService service;

    //JWT
    @Autowired
    private JwtService jwtService;
    //JWT
    @Autowired
    private AuthenticationManager authManager;

    @GetMapping("/hi")
    public String hello(Authentication authentication){

        User user = (User) authentication.getPrincipal();

        return "Hello " + user.getUsername();
    }


        //  ++++++++++++ MANUAL WAY TO SAVE DATA (HARD CODING) +++++++++++++++

//    @GetMapping("/save")
//    public String save(){
//        return service.saveUser();
//    }


//    ++++++++++++++ DTO WAY +++++++++++++

    @PostMapping("/save")
    public String save(@RequestBody UserDto dto){
        return service.save(dto);
    }

    //JWT
    @PostMapping("/login")
    public String login(@RequestBody UserDto dto) {

        authManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        dto.getUsername(),
                        dto.getPassword()
                )
        );

        return jwtService.generateToken(dto.getUsername());
    }


    @GetMapping("/hello-secure")
    public String secure() {
        return "You are authenticated!";
    }


}
