package com.undefitable.TrainingInstitute.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.undefitable.TrainingInstitute.Entities.AuthRequest;
import com.undefitable.TrainingInstitute.Entities.User;
import com.undefitable.TrainingInstitute.Services.JwtService;
import com.undefitable.TrainingInstitute.Services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userservice;
	
	  
	    @Autowired
	    private JwtService jwtService;

	    @Autowired
	    private AuthenticationManager authenticationManager;

	    @GetMapping("/welcome")
	    public String welcome() {
	        return "Welcome this endpoint is not secure";
	    }

	    
	   
	    @PostMapping("/new")
	    public User addNewUser(@RequestBody User user) {
	     return userservice.addUser(user);
	      //return "User added successfully with "+user.getUsername();
	    }

	    @GetMapping("admin/all")
	    @PreAuthorize("hasAuthority('[ROLE_ADMIN]')")
	    public String welcome1() {
	        return "Welcome this endpoint is not secure";
	    }

	    @GetMapping("/{id}")
	    @PreAuthorize("hasAuthority('ROLE_USER')")
	    public User getProductById(@PathVariable Long id) {
	        return userservice.getUserById(id);
	    }


	    @PostMapping("/authenticate")
	    public String authenticateAndGetToken(@RequestBody AuthRequest authRequest) {
	        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
	        if (authentication.isAuthenticated()) {
	            return jwtService.generateToken(authRequest.getUsername());
	        } else {
	            throw new UsernameNotFoundException("invalid user request !");
	        }


	    }

	
	    //Json Request
	    
//	    {
//
//	    	"username":"kmabhi083",
//	    	"password":"kmabhi083",
//	    	"mobile":"8006494238",
//	    	"email":"jitin483@gmail.com",
//	    	"address":"Exampur"
//	    	 
//	    	}
	    
}
