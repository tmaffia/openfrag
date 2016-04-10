package com.openfrag.repository;

import com.openfrag.OpenfragApplication;
import com.openfrag.entity.User;
import com.openfrag.exception.InvalidPasswordException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

/**
 * Created by tmaffia on 4/9/16.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = OpenfragApplication.class)
public class UserRepositoryTest {

    @Autowired
    private UserRepository target;


    @Before
    public void setup() {
        User u = new User("abc", "first", "last", "email@email.com",
                "Password12", "en-us");
        u.setPathString("/home/user/Desktop");
        if (target.findByUsername("abc") == null) {
            target.saveAndFlush(u);
        }
    }

    @After
    public void destory() {
        target.delete(target.findByEmail("email@email.com"));
    }


    @Test(expected = RuntimeException.class)
    public void testCreateInvalidPassword() {
        User u = new User("abcd", "first", "last", "email2@email.com",
                "password", "en-us");
        u.setPathString("/home/user2/Desktop");
        target.saveAndFlush(u);
    }

    @Test
    public void testFindByEmail() {
        User u = target.findByEmail("email@email.com");
        assertEquals("abc", u.getUsername());
    }

    @Test
    public void testFindByUsername() {
        User u = target.findByUsername("abc");
        assertEquals("email@email.com", u.getEmail());
    }

    @Test
    public void testFindByEmailAndPassword() {
        User u = target.findByEmailAndPassword("email@email.com", "Password12");
        assertEquals("abc", u.getUsername());
    }

    @Test
    public void testFindByUsernameAndPassword() {
        User u = target.findByUsernameAndPassword("abc", "password");
    }

}
