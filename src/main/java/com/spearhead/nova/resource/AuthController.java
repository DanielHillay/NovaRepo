package com.spearhead.nova.resource;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;


import com.spearhead.nova.model.StandardResponse;
import com.spearhead.nova.model.User;
import com.spearhead.nova.model.endpoint.ExistingCustomer;
import com.spearhead.nova.model.endpoint.SignOn;
import com.spearhead.nova.service.AuthService;
import com.spearhead.nova.service.impl.NotificationService;
import com.spearhead.nova.util.MethodUtils;






@Api(value = "Auth Controller", tags = {"Authentication"} , description = "Rest APIs that Manages the User Activities")
@RestController
@RequestMapping("/auth")
public class AuthController {

	

		
	@Autowired
	private AuthService authService;

	@Autowired
    NotificationService NService;

	

	@ResponseStatus(HttpStatus.OK)
	@PostMapping("/login")
	public ResponseEntity<String> authenticatUser(@RequestBody SignOn LoginInfo) throws Exception{
	
		
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("x-auth-token", "Here");
			// Use the SignOn to Get the user Information into User
		
			return authService.authenticate(LoginInfo);
	}



	@PostMapping(value = "/registernewcustomer",  consumes="application/json", produces = "application/json")
	public ResponseEntity<StandardResponse> registerUser(@RequestBody User user) throws IllegalArgumentException {

		return authService.registerUser(user);
	}
	
	@PostMapping(value = "/admin/registeradmin",  consumes="application/json", produces = "application/json")
	public ResponseEntity<StandardResponse> registerAdmin(@RequestBody User user) throws IllegalArgumentException {

		return authService.registerUser(user);
	}



	
	@PostMapping(value = "/testNotification",  consumes="application/json", produces = "application/json")
	public ResponseEntity<StandardResponse> testNotification(@RequestBody User user) throws IllegalArgumentException {

		NService.sendRegistrationNotification(user);
		
		return new ResponseEntity<StandardResponse>(new StandardResponse(true, "sent"), HttpStatus.OK);
	}

	
	@PostMapping(value = "/registerexistingcustomer",  consumes="application/json", produces = "application/json")
	public ResponseEntity<StandardResponse> registerexistingcustomer(@RequestBody ExistingCustomer customer ) throws IllegalArgumentException {
		// Here we would consume the external API to populate the user details then we send the user an validation 

		// Call the API to fetch the Customer Details and Compare it

		User user = new User();
		user.setUsername("username");
		user.setPassword(customer.getPassword());
		user.setEmail("ralekeo@gmail.com");
		return authService.registerUser(user);
	}

	@PostMapping(value = "/validateOTP/{token}", consumes="application/json", produces = "application/json")
	public ResponseEntity<String> ValidateToken(@RequestParam String token) {
		
		//HttpHeaders responseHeaders = new HttpHeaders();
				
		// responseHeaders.set("x-auth-token", "Here");
		return new ResponseEntity<String>(MethodUtils.prepareResponseJSON(HttpStatus.OK, "Returned Something"), HttpStatus.OK);
		
	}
	
	
	@PostMapping(value = "/resetPassword", consumes="application/json", produces = "application/json")
	public ResponseEntity<String> resetPassword(@RequestBody User user) {
		
		//HttpHeaders responseHeaders = new HttpHeaders();
				
		// responseHeaders.set("x-auth-token", "Here");
		return new ResponseEntity<String>(MethodUtils.prepareResponseJSON(HttpStatus.OK, "Returned Something"), HttpStatus.OK);
		
	}
	
}
