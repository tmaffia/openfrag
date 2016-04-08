package com.openfrag.entity;

import javax.persistence.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.Locale;

/**
 * Created by tmaffia on 4/7/16.
 */

@Entity
public class User {

    @Id
    @GeneratedValue
    private long id;
	@Column( unique = true )
    private String userName;
    private String firstName;
    private String lastName;
    @Column( unique = true )
    private String email;
    private String password;
    @Transient
    private Locale locale;
    private String localeString;
    @Transient
    private Path path;
    @Column( unique = true )
    private String pathString;
    private Date created;
    private Date modified;
    @OneToOne
    private UserImage userImage;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Locale getLocale() {
        return locale;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }

    public String getLocaleString() {
        return localeString;
    }

    public void setLocaleString(String localeString) {
        this.localeString = localeString;
    }

    public Path getPath() {
        return path;
    }

    public void setPath(Path path) {
        this.path = path;
    }

    public String getPathString() {
        return pathString;
    }

    public void setPathString(String pathString) {
        this.pathString = pathString;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }

    public Locale createLocaleFromString() {
        locale = Locale.forLanguageTag(localeString);
        return locale;
    }

    public Path createPathFromString() {
        path = Paths.get(pathString);
        return path;
    }
}
