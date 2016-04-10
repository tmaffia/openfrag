package com.openfrag.listener;

import com.openfrag.entity.User;
import com.openfrag.exception.InvalidPasswordException;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

/**
 * Created by tmaffia on 4/10/16.
 */

public class UserValidationListener {

    private static final String NAME_REGEX = "^[\\p{L} .'-]+$";
    private static final String MEMBER_ID_REGEX = "^[\\p{L} .'-]+$";
    private static final String PASSWORD_REGEX = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{8,}$";

    @PrePersist
    @PreUpdate
    void validate(User user)
            throws AddressException, InvalidPasswordException {
        validateUsername(user);
        validateFirstName(user);
        validateLastName(user);
        validateEmail(user);
        validatePassword(user);
        validateLocale(user);
        validatePath(user);

    }

    private void validateUsername(User user) {
        if (user.getUsername() == null ||
                !user.getUsername().matches(MEMBER_ID_REGEX)) {
            throw new IllegalArgumentException("Invalid Username");
        }
    }

    private void validateFirstName(User user) {
        if (user.getFirstName() == null ||
                !user.getFirstName().matches(NAME_REGEX)){
            throw new IllegalArgumentException("Invalid first name for User");
        }
    }

    private void validateLastName(User user) {
        if (user.getLastName() == null ||
                !user.getLastName().matches(NAME_REGEX)){
            throw new IllegalArgumentException("Invalid last name for User");
        }
    }

    private void validateEmail(User user) throws AddressException {
        InternetAddress addr = new InternetAddress(user.getEmail());
        addr.validate();
    }


    private void validatePassword(User user) throws InvalidPasswordException {
        if (user.getPassword() == null || !user.getPassword().matches(PASSWORD_REGEX)) {
            throw new InvalidPasswordException("Invalid Password");
        }
    }

    private void validateLocale(User user) {
        if (user.getLocale() == null) {
            throw new IllegalArgumentException("Invalid or empty Locale");
        }
    }

    private void validatePath(User user) {
        if (user.getPath() == null) {
            throw new IllegalArgumentException("Invalid or empty Path");
        }
    }
}
