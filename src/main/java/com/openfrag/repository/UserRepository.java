package com.openfrag.repository;

import com.openfrag.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by tmaffia on 4/8/16.
 */

@Repository
public interface UserRepository extends JpaRepository<User,Long>{

    User findByEmail(String email);
    User findByUsername(String username);
    User findByEmailAndPassword(String email, String password);
    User findByUsernameAndPassword(String username, String password);
}
