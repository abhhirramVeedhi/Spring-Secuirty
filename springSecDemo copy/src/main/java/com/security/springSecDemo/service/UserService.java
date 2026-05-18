package com.security.springSecDemo.service;


import com.security.springSecDemo.config.SecurityConfig;
import com.security.springSecDemo.dto.UserDto;
import com.security.springSecDemo.model.UserModel;
import com.security.springSecDemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    @Autowired
    private SecurityConfig securityConfig;


//  ++++++++++++ MANUAL WAY TO SAVE DATA (HARD CODING) +++++++++++++++


//    public String saveUser(){
//        UserModel u = new UserModel();
//        u.setUsername("ram");
//        u.setPassword("ram");
//        u.setEmail("ram@gmail.com");
//
//        UserModel u1 = new UserModel();
//        u.setUsername("abhi");
//        u.setPassword("abhi");
//        u.setEmail("abhi@gmail.com");
//
//
//
//        repo.save(u);
//        repo.save(u1);
//
//        return "User ram saved";
//    }

//    +++++++++++++++ DTO WAY ++++++++++++++++++


    public String save(UserDto dto){
        UserModel u = new UserModel();

        u.setUsername(dto.getUsername());
        u.setPassword(securityConfig.passwordEncoder().encode(dto.getPassword()));

        repo.save(u);

        return "User saved";
    }

}
