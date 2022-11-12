package com.spearhead.nova.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "admin_user")
@Data
@RequiredArgsConstructor
public class AdminUser {

    @Id
    @GeneratedValue(generator = "admin_user_generator")
    @SequenceGenerator(
            name = "admin_user_generator",
            sequenceName = "admin_user_sequence",
            initialValue = 1000
    )
    private Long id;
    private Long userId;
    private String email;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String phoneNumber;
    private String role;


    @Override
    public String toString() {
        //return new Gson().toJson(this);
//		return "{\"userId\":" + userId +",\"username\":" + username + ",\"firstName\":"+ firstName + ",\"email\":" + email + ",\"userType\":" + userType +   "\"}";
        return "{\"userId\":" + id +",\"role\":" + role + ",\"username\":\""+username+"\",\"name\":\""+ firstName+"\",\"email\":\""+email+"\"}";
    }
}
