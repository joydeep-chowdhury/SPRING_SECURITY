package com.joydeep.security.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joydeep.security.dao.UserRepository;
import com.joydeep.security.model.User;

@RestController
@RequestMapping("api/public")
public class PublicRestApiController {
    @Autowired
	private UserRepository userRepo;
    public PublicRestApiController(){}

    @GetMapping("test1")
    public String test1(){
        return "API Test 1";
    }

    @GetMapping("test2")
    public String test2(){
        return "API Test 2";
    }
    @Autowired
    @GetMapping("users")
    public List<User> users()
    {
    	return userRepo.findAll();
    }

}
