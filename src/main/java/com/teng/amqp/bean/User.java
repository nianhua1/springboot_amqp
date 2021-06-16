package com.teng.amqp.bean;

/**
 * @author shkstart
 * @create 2021-06-16 20:48
 */
public class User {
    private String userName;
    private Integer age;
    private String gender;

    public User() {
    }

    public User(String userName, Integer age, String gender) {
        this.userName = userName;
        this.age = age;
        this.gender = gender;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                '}';
    }
}
