package com.openfrag.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by tmaffia on 4/7/16.
 */
public class UserImage {

    @Id
    @GeneratedValue
    private long id;
    private String path;

}
