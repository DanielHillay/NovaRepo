package com.spearhead.nova.resource;

import java.util.List;

// import java.util.Arrays;
// import java.util.List;

import com.spearhead.nova.repository.UserRepository;
import org.json.JSONObject;
// import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.spearhead.nova.model.StandardResponse;
import com.spearhead.nova.model.SupportResponse;
import com.spearhead.nova.model.User;
import com.spearhead.nova.service.UserService;
import com.spearhead.nova.util.MethodUtils;

import io.swagger.annotations.Api;

@Api(value = "User Endpoints", tags = {
        "Customer" }, description = "Rest APIs that Returns Information Corncering the Customer")
@RestController
@RequestMapping("/admin/api/customer")
public class UserController {

    @Autowired
    // // Using Rest Template to consume external endpoint
    RestTemplate restTemplate;

	@Autowired
	UserRepository userRepository;

    @Autowired
    private UserService userServices;
//     @GetMapping("/alluser")
//     public List<User> getUser() {
//    	 return userServices.getUser();
//     }
     
     
     @GetMapping("/alluser")
     public ResponseEntity<StandardResponse> getUser() {
    	 
    	 Object data = userServices.getUser();
    	// return userServices.getUser();
    	 
    	 StandardResponse sr = new StandardResponse();
 		
 		try {
 			
 			sr.setStatus(true);
 			sr.setStatuscode("200");
 			sr.setMessage("User Succefully Returned");
 			sr.setData(data);
 			
 			 return new ResponseEntity<StandardResponse>(sr, HttpStatus.OK);
 		}catch(Exception e) {
 			sr.setStatus(false);
 			return new ResponseEntity<StandardResponse>(sr, HttpStatus.BAD_REQUEST);
 		}
 		
     }
     
     

    @GetMapping("/details")
    public ResponseEntity<String> getAllUsers() {

        // RestTemplate restTemplate = new RestTemplate();
        // String path = "https://bloomerapi.azurewebsites.net/api/getusers";
        System.out.println("Hello ");
		StandardResponse sr = new StandardResponse();

        try {

            //String allUsers = restTemplate.getForObject(path, String.class);

            //JSONObject apiResponse = new JSONObject(allUsers);
            //System.out.println("API " + apiResponse);
           // JSONObject response = apiResponse.getJSONObject("data");// .getJSONObject("data");//.getJSONArray("allUsers");
           // System.out.println("API " + response);

            // ResponseEntity<String> resp = restTemplate.exch(path, HttpMethod.GET, null,
            // null, null );

			List<User> listOfUsers = userRepository.findAll();

			sr.setData(listOfUsers);
			sr.setMessage("Your list of USERS");
			sr.setStatus(true);
			sr.setStatuscode("200");

            // re
            //return ResponseEntity.ok().body(response.toString());

			return new ResponseEntity<String>(sr.getMessage(), HttpStatus.OK);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return new ResponseEntity<String>(
                    MethodUtils.prepareResponseJSON(HttpStatus.BAD_REQUEST, "Returned Something"),
                    HttpStatus.BAD_REQUEST);
        }

    }
    
    
//	@PutMapping("/updateuserstatus/{id}")
//	public String  updateStatusById(@PathVariable("id") Long userId) {
//		userServices.updateStatusById(userId);
//		return "User have been Successfully Suspended";
//	}
	
	@PutMapping("/updateuserstatus/{id}")
	 public ResponseEntity<StandardResponse> updateStatusById(@PathVariable("id") Long userId) {
		
		StandardResponse sr = new StandardResponse();
		
		try {
			
			userServices.updateStatusById(userId);
			sr.setStatus(true);
			sr.setStatuscode("200");
			sr.setMessage("Update Succesfull");
			
			 return new ResponseEntity<StandardResponse>(sr, HttpStatus.OK);
		}catch(Exception e) {
			sr.setStatus(false);
			return new ResponseEntity<StandardResponse>(sr, HttpStatus.BAD_REQUEST);
		}
		
		//return userServices.updateStatusById(userId);
	}
	
	@DeleteMapping("/deleteuser/{id}")
	ResponseEntity<StandardResponse> deleteSupport(@PathVariable("id") Long userId) {
		
	StandardResponse sr = new StandardResponse();
		
		try {
			
			userServices.deleteUser(userId);
			sr.setStatus(true);
			sr.setStatuscode("200");
			sr.setMessage("Successful Deletion");
			
			 return new ResponseEntity<StandardResponse>(sr, HttpStatus.OK);
		}catch(Exception e) {
			sr.setStatus(false);
			return new ResponseEntity<StandardResponse>(sr, HttpStatus.BAD_REQUEST);
		}
		 
	}
}
