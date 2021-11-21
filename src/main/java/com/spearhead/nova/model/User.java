package com.spearhead.nova.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


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
    

 
    

	public User() {
		super();
	}	

	public User(String username, String firstName, String lastName,  String email, String password ) {
		super();
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;

	
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
		return "{\"userId\": " + userId + ",\"username\":\""+username+"\",\"name\":\""+ firstName+"\",\"email\":\""+email+"\"}";
	}
		    
}
