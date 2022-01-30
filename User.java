package com.spearhead.nova.model;


import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

//import com.google.gson.Gson;


@Entity
@Table(name = "users",schema="dbo" ,uniqueConstraints = {
        @UniqueConstraint(columnNames = {
            "email"
        })
})

public class User extends DateAudit{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue(generator = "admin_user_generator")
    @SequenceGenerator(
   		name = "admin_user_generator",
   		sequenceName = "admin_user_sequence",
   		initialValue = 1000
   		)
	private Long userId;
    
    private String username;
    
    private String firstName;



	private String lastName;
	
    
    private String email;
    
    private String password;

	private String customerId;
	
	private String userStatus;
    
	private String userType;
	
	
	
	
	
	public String getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}




	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Collection<Role> roles = new ArrayList<>();
 
    

	

	public Collection<Role> getRoles() {
		return roles;
	}

	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public User() {
		super();
	}	

	


	

	public User(Long userId, String username, String firstName, String lastName, String email, String password,
			String customerId, String userStatus, String userType, Collection<Role> roles) {
		super();
		this.userId = userId;
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.customerId = customerId;
		this.userStatus = userStatus;
		this.userType = userType;
		this.roles = roles;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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


	    
	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customercode) {
		this.customerId = customercode;
	}
	

	

	@Override
	public String toString() {
		//return new Gson().toJson(this);
//		return "{\"userId\":" + userId +",\"username\":" + username + ",\"firstName\":"+ firstName + ",\"email\":" + email + ",\"userType\":" + userType +   "\"}";
		return "{\"userId\":" + userId +",\"username\":\""+username+"\",\"name\":\""+ firstName+"\",\"email\":\""+email+"\"}";
	}
		    
		    
}
