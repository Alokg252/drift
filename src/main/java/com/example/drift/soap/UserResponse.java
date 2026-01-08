package com.example.drift.soap;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "GetUserResponse")
public class UserResponse {

    @XmlElement
    private int userId;

    @XmlElement
    private String name;

    @XmlElement
    private String email;

    @XmlElement
    private String status;

    public UserResponse() {
    }

    public UserResponse(int userId, String name, String email, String status) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.status = status;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
