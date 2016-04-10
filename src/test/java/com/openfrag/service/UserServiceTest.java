package com.openfrag.service;

import com.openfrag.OpenfragApplication;
import com.openfrag.entity.User;
import com.openfrag.exception.CreateUserException;
import com.openfrag.exception.DeleteUserException;
import com.openfrag.exception.EmailAlreadyRegisteredException;
import com.openfrag.exception.UsernameAlreadyRegisteredException;
import com.openfrag.repository.UserRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.*;

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
        assertEquals(u.getUsername(),
                userRepository.findByEmail(u.getEmail()).getUsername());
    }

    @Test
    public void testDeleteUser() {
        User u = userRepository.findByUsername("abcd");
        try {
            target.deleteUser(u);
        }catch (DeleteUserException e) {
            fail();
        }
        assertNull(userRepository.findByEmail(u.getEmail()));
    }

    @Test
    public void testUserExistsByUsername() {
        User u = new User();
        u.setUsername("abcd");
        assertTrue(target.userExists(u));
        u.setUsername("doesnt_exist");
        assertFalse(target.userExists(u));
    }

    @Test
    public void testUserExistsByEmail() {
        User u = new User();
        u.setEmail("email1@email.com");
        assertTrue(target.userExists(u));
        u.setEmail("e@emai.com");
        assertFalse(target.userExists(u));
    }
}
