package com.example.e_softwarica.models;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String username;
    private String password;
    static List<User> userList = new ArrayList<>();
    boolean result = false;

    public User() {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public boolean userLogin() {
        if (getUserList() != null) {

            for (int i = 0; i < getUserList().size(); i++) {
                final User userdetail = getUserList().get(i);
                if (username.equals(userdetail.getUsername()) && password.equals(userdetail.getPassword())) {
                    result = true;
                } else {
                    result = false;
                }
            }
        } else {
            result = false;
        }
        return result;

    }
}
