package com.behsa.smsGw.Repository;

import com.behsa.smsGw.Entity.UserLogin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserLogin,Long> {
    UserLogin findByUsername(String username);
    public UserLogin findByUserPass(String username, String password);
}
