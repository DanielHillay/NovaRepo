package com.spearhead.nova.model;

import java.util.Collection;
import java.util.Objects;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;


public class UserPrincipal implements UserDetails {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long userId;
	
    private String username;
    
    private String email;

    @JsonIgnore   
    private String password;

    private Collection<? extends GrantedAuthority> authorities;
  
    

    public UserPrincipal(Long userId, String username,String email,String password
    // , Collection<? extends GrantedAuthority> authorities
    ) {
		super();
		this.userId = userId;
		this.username = username;
		this.email=email;
		this.password = password;
		// this.authorities = authorities;
	}

	public static UserPrincipal create(AdminUser user) {
     /*    List<GrantedAuthority> authorities = Stream.of(user.getRole())
        	.map(role -> new SimpleGrantedAuthority(role.getName().name()))
        	.collect(Collectors.toList()); */
       
        return new UserPrincipal(user.getUserId(),user.getEmail(),user.getEmail(),user.getPassword());
    }

	
    public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
	
	@Override
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserPrincipal that = (UserPrincipal) o;
        return Objects.equals(userId, that.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId);
    }
}