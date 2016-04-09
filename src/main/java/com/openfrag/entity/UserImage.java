package com.openfrag.entity;

import javax.persistence.*;

/**
 * Created by tmaffia on 4/7/16.
 */

@Entity
public class UserImage {

    @Id
    @GeneratedValue
    private long id;
    @OneToOne
    private User user;
    @Column(unique = true)
    private String path;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
