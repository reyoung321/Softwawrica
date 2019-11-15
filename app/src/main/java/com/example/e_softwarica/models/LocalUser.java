package com.example.e_softwarica.models;

import java.util.ArrayList;
import java.util.List;

public class LocalUser {

    int a;
    static List<LocalUser> userList=new ArrayList<>();
    private int imageId;
    private String name;
    private String age;
    private String address;
    private String gender;

    public List<LocalUser> getUserList() {
        return userList;
    }

    public void setUserList(List<LocalUser> userList) {
        this.userList = userList;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

}
