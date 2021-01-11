package com.example.mvvmapp.bean;

/**
 * Author: Zeus
 * Date: 2020/7/13 17:16
 * Description:
 * History:
 */
public class User {
    private String name;
    private String lastName;
    private String avatar;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
