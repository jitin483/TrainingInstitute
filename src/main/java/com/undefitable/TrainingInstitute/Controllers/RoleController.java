package com.undefitable.TrainingInstitute.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.undefitable.TrainingInstitute.Entities.Role;
import com.undefitable.TrainingInstitute.Services.RoleService;

@RestController
@RequestMapping("/Role")
public class RoleController {

	@Autowired
	private RoleService roleservice;
	
	 @PostMapping("/{createNewRole}")
	    public Role createNewRole(@RequestBody Role role) {
	        return roleservice.createRole(role);
	    }

	    @GetMapping("/{id}")
	    public Role getUserById(@PathVariable Long id) {
	        return roleservice.getRoleById(id);
	    }
}
