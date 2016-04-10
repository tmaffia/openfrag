package com.openfrag.service;

import com.openfrag.entity.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by tmaffia on 4/10/16.
 */

@Service
public class FileUtilService {

    @Value("${user.base.path}")
    public String BASE_PATH;

    public Path createUserDirectory(User u) throws IOException {
        Path p = Paths.get(BASE_PATH + u.getUsername() + "/");
        Files.createDirectories(p);
        return p;
    }
}
