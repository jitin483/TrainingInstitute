package com.undefitable.TrainingInstitute.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.undefitable.TrainingInstitute.Dao.RoleRepository;
import com.undefitable.TrainingInstitute.Entities.Role;

@Service
public class RoleService {

	@Autowired
	private RoleRepository rolerepo;
	
	public Role createRole(Role role) {
		return rolerepo.save(role);
	}
	public Role getRoleById(Long id) {
		return rolerepo.getById(id);
	}
}
