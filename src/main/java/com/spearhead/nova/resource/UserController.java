package com.spearhead.nova.resource;

// import java.util.Arrays;
// import java.util.List;

import org.json.JSONObject;
// import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.spearhead.nova.util.MethodUtils;

import io.swagger.annotations.Api;

@Api(value = "User Endpoints", tags = {
        "Customer" }, description = "Rest APIs that Returns Information Corncering the Customer")
@RestController
@RequestMapping("/api/customer")
public class UserController {

    @Autowired
    // // Using Rest Template to consume external endpoint
    RestTemplate restTemplate;

    // @GetMapping("/details")
    // public String getUser() {
    // return "Maybe We return the User Information based on the User token";
    // }

    @GetMapping("/details")
    public ResponseEntity<String> getAllUsers() {

        System.out.println("Hello ");
        // RestTemplate restTemplate = new RestTemplate();
        String path = "https://bloomerapi.azurewebsites.net/api/getusers";
        System.out.println("Hello ");

        try {

            String allUsers = restTemplate.getForObject(path, String.class);

            JSONObject apiResponse = new JSONObject(allUsers);
            System.out.println("API " + apiResponse);
            JSONObject response = apiResponse.getJSONObject("data");// .getJSONObject("data");//.getJSONArray("allUsers");
            System.out.println("API " + response);

            // ResponseEntity<String> resp = restTemplate.exch(path, HttpMethod.GET, null,
            // null, null );

            // re
            return ResponseEntity.ok().body(response.toString());

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return new ResponseEntity<String>(
                    MethodUtils.prepareResponseJSON(HttpStatus.BAD_REQUEST, "Returned Something"),
                    HttpStatus.BAD_REQUEST);
        }

    }
}
