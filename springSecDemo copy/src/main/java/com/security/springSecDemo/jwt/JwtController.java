package com.security.springSecDemo.jwt;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JwtController {

    @Autowired
    private JwtService jwtService;


    @GetMapping("/token")
    public String getToken(){
        return jwtService.generateToken("aram");
    }

    @GetMapping("/extract")
    public String extractUserName(@RequestParam String token){
        return jwtService.extractUsername(token);
    }
}
