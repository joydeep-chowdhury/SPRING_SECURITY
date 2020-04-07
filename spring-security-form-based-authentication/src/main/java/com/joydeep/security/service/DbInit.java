package com.joydeep.security.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.joydeep.security.dao.UserRepository;
import com.joydeep.security.model.User;

@Service
public class DbInit implements CommandLineRunner {
	@Autowired
	private UserRepository userRepo;
	@Autowired
    private PasswordEncoder pe;
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		this.userRepo.deleteAll();
         User dan=new User("dan",pe.encode("dan@123"),"USER", "");
         User admin=new User("admin",pe.encode("admin@123"),"ADMIN", "ACCESS_TEST1,ACCESS_TEST2");
         User manager=new User("manager",pe.encode("manager@123"),"MANAGER", "ACCESS_TEST1");
         List<User> users=Arrays.asList(dan,admin,manager);
         this.userRepo.saveAll(users);
	}
}
