package com.undefitable.TrainingInstitute.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.undefitable.TrainingInstitute.Dao.UserRepository;
import com.undefitable.TrainingInstitute.Entities.User;

@Service 
public class UserService {

	@Autowired
	private UserRepository userrepo;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public User addUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userrepo.save(user);
        return user;
    }
	
	public User  getUserById(Long id) {
		return userrepo.getReferenceById(id);
	}
	
	public List<User>  alluser() {
		return userrepo.findAll();
	}
	
}
