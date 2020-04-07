package com.joydeep.security.dao;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.joydeep.security.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
   public abstract User findByUsername(String username);
}
