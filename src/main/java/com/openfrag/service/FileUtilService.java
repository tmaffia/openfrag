package com.openfrag.service;

import com.openfrag.entity.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

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

    public void deleteUserDirectory(User u) throws IOException {
        deleteDir(u.getPath());
    }

    private void deleteDir(Path p) throws IOException {
        Files.walkFileTree(p, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                Files.delete(file);
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                Files.delete(dir);
                return FileVisitResult.CONTINUE;
            }
        });
    }
}
