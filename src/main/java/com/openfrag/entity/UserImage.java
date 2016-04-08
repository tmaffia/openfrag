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
    @Column( unique = true )
    private String path;
}
