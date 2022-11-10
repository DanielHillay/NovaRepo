package com.spearhead.nova.service;


import javax.transaction.Transactional;

import com.spearhead.nova.model.*;
import com.spearhead.nova.repository.AdminRepository;
import com.spearhead.nova.service.impl.SendGridEmailService;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
/* import org.slf4j.Logger;
import org.slf4j.LoggerFactory; */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.spearhead.nova.model.endpoint.SignOn;
import com.spearhead.nova.repository.AuditlogRepository;
import com.spearhead.nova.repository.RoleRepository;
import com.spearhead.nova.repository.UserRepository;
import com.spearhead.nova.security.JwtTokenProvider;
import com.spearhead.nova.service.impl.NotificationService;
import com.spearhead.nova.util.MethodUtils;




@Service
@Transactional
public class AuthService {
	
	
	@Autowired
    AuthenticationManager authenticationManager;
	
    @Autowired
    PasswordEncoder passwordEncoder;
    
	@Autowired
    NotificationService NService;

    @Autowired
    UserRepository userRepository;
    
    @Autowired
    RoleRepository roleRepository;
    
    @Autowired
    JwtTokenProvider tokenProvider;

	@Autowired
	SendGridEmailService sendGrid;

	@Autowired
	AdminRepository adminRepo;
    
    @Autowired
	private AuditlogRepository auditlogRepo;
    
  // private static final Logger logger = LoggerFactory.getLogger(AuthService.class);
    
    
    @Value("${spring.mail.username}")
    private String EMAIL_SENDER;
    
    
    
	public ResponseEntity<String> authenticate(SignOn user) {
		
		JSONObject jsonObject = new JSONObject();
		try {
				Authentication authentication = authenticationManager
						.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword()));
			if (authentication.isAuthenticated()) {
				
				
				
				HttpHeaders responseHeaders = new HttpHeaders();
				String email = user.getUsername() ;
	
				SecurityContextHolder.getContext().setAuthentication(authentication);
	
			    String jwt = tokenProvider.generateToken(authentication);
			    
			    AdminUser loggedInUser = adminRepo.findByEmail(email).get();
			    
			    jsonObject.put("user_details", new JSONObject(loggedInUser.toString()));
				jsonObject.put("token", jwt);
				
				responseHeaders.set("x-auth-token", jwt);
				
				AuditLogs auditlog = new AuditLogs();
				//auditlog.setAutologId(null);
				auditlog.setAction("Logged In");
				auditlog.setUserName(email);
				auditlogRepo.save(auditlog);
	    
				return new ResponseEntity<String>(MethodUtils.prepareResponseJSON(HttpStatus.OK, jsonObject.toString()),
						responseHeaders, HttpStatus.OK);
	
				}
			} 
			catch (BadCredentialsException e) {
				System.out.println("Hello world 2");
				return new ResponseEntity<String>(MethodUtils.prepareErrorJSON(HttpStatus.BAD_REQUEST, "Either email or password is incorrect"), HttpStatus.BAD_REQUEST);
			} catch (JSONException e) {
				try {
					System.out.println("Hello world 3");
					jsonObject.put("exception", e.getMessage());
				} catch (JSONException e1) {
					System.out.println("Hello world 4");
					e1.printStackTrace();
				}
		
				return new ResponseEntity<String>(MethodUtils.prepareErrorJSON(HttpStatus.INTERNAL_SERVER_ERROR,
						e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
				
			}

			return new ResponseEntity<String>(MethodUtils.prepareErrorJSON(HttpStatus.INTERNAL_SERVER_ERROR, "Something went wrong"),
					HttpStatus.INTERNAL_SERVER_ERROR);
	
}
	


	public ResponseEntity<StandardResponse> registerUser(User user){
		
	
		StandardResponse sr = new StandardResponse();

		try {
			Boolean loggedInUser = userRepository.findByEmail(user.getEmail()).isPresent();

		if (!loggedInUser) {
			String password = passwordEncoder.encode(user.getPassword());
			user.setPassword(password);
			userRepository.save(user);
			//NService.sendRegistrationNotification(user);
			sendGrid.sendGridNotification(user);
		
			
			sr.setStatus(true);
			sr.setMessage("User Registered");
	
			return new ResponseEntity<StandardResponse>(sr, HttpStatus.OK);

			} else {
					
				sr.setStatus(false);
				sr.setMessage("Email Already Exists");
				return new ResponseEntity<StandardResponse>(sr, HttpStatus.OK);
			}

		}  catch(Exception ex){
			
			sr.setStatus(false);
			sr.setMessage(ex.getMessage());
		}

		return new ResponseEntity<StandardResponse>(sr, HttpStatus.INTERNAL_SERVER_ERROR);
	
	}
	public ResponseEntity<StandardResponse> registerAdmin(AdminUser user){


		StandardResponse sr = new StandardResponse();

		try {
			Boolean loggedInUser = adminRepo.findByEmail(user.getEmail()).isPresent();

			if (!loggedInUser) {
				String password = passwordEncoder.encode(user.getPassword());
				user.setPassword(password);
				//userRepository.save(user);
				adminRepo.save(user);
				//NService.sendRegistrationNotification(user);
				//sendGrid.sendGridNotification(user);


				sr.setStatus(true);
				sr.setMessage("User Registered");

				return new ResponseEntity<StandardResponse>(sr, HttpStatus.OK);

			} else {

				sr.setStatus(false);
				sr.setMessage("Email Already Exists");
				return new ResponseEntity<StandardResponse>(sr, HttpStatus.OK);
			}

		}  catch(Exception ex){

			sr.setStatus(false);
			sr.setMessage(ex.getMessage());
		}

		return new ResponseEntity<StandardResponse>(sr, HttpStatus.INTERNAL_SERVER_ERROR);

	}
	
	
	public void addRoleToUser(String email, String roleName) {
		Object user = userRepository.findByEmail(email);
		Role role  = roleRepository.findByName(roleName);
		
		((User) user).getRoles().add(role);
		
	}
}