package com.openfrag.service;

import com.openfrag.OpenfragApplication;
import com.openfrag.entity.User;
import com.openfrag.exception.CreateUserException;
import com.openfrag.exception.DeleteUserException;
import com.openfrag.repository.UserRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.fail;

/**
 * Created by tmaffia on 4/10/16.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = OpenfragApplication.class)
public class UserServiceTest {

    @Autowired
    private UserService target;

    @Autowired
    private UserRepository userRepository;

    @Before
    public void setup() {
        if (userRepository.findByUsername("abcd") == null) {
            User u = new User("abcd", "first", "last", "email1@email.com",
                    "Password12", "en-us");
            try {
                 target.createUser(u);
            } catch (CreateUserException e) {
            }
        }
    }

    @Test
    public void testCreateUser() {
        User u = new User("abc", "first", "last", "email@email.com",
                "Password12", "en-us");
        try {
            target.createUser(u);
        } catch (CreateUserException e) {
            fail();
        }
    }

    @Test
    public void testDeleteUser() {
        User u = userRepository.findByUsername("abcd");
        try {
            target.deleteUser(u);
        }catch (DeleteUserException e) {
            fail();
        }
    }
}
