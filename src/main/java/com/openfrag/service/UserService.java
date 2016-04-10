package com.openfrag.service;

import com.openfrag.entity.User;
import com.openfrag.exception.CreateUserException;
import com.openfrag.exception.DeleteUserException;
import com.openfrag.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * Created by tmaffia on 4/10/16.
 */

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private FileUtilService fileUtilService;

    public User createUser(User u) throws CreateUserException {
        try {
            u.setPath(fileUtilService.createUserDirectory(u));
            return userRepository.saveAndFlush(u);
        } catch (IOException e) {
            e.printStackTrace();
            throw new CreateUserException("Error Creating User");
        }
    }

    public void deleteUser(User u) throws DeleteUserException {
        try {
            fileUtilService.deleteUserDirectory(u);
            userRepository.delete(u.getId());
        } catch (IOException e) {
            throw new DeleteUserException("Error Deleting User");
        }
    }
}
