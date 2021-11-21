package com.spearhead.nova.resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;


@Api(value = "User Endpoints",tags={"Customer"}, description = "Rest APIs that Returns Information Corncering the Customer")
@RestController
@RequestMapping("/api/customer")
public class UserController {
    

    @GetMapping("/details")
	public String getUser() {
		return "Maybe We return the User Information based on the User token";
	}
}
