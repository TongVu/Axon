package com.example.demo.restcontrollers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.demo.services.UserService;
import com.example.demo.services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.User;
import com.example.demo.exceptions.ResourceNotFoundException;


@RestController
@CrossOrigin(maxAge = 3600)
@RequestMapping("/api/user")
public class UserRESTController {
	@Autowired
	private UserServiceImpl userService;

	/**
	 * Get all users list.
	 *
	 * @return the list
	 */
	@GetMapping("/list")
	public List<User> getAll() {
		
		return userService.getAllUser();
		
		
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<User> getUserById(@PathVariable(value = "id") Long userId) 
			throws ResourceNotFoundException {
		User user = userService.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User not found on: " + userId));

		return ResponseEntity.ok().body(user);
	}

	/**
	 * Create user user.
	 *
	 * @param user the user
	 * @return the user
	 */
	@PostMapping("/add")
	public User create(@RequestBody User user) {
		return userService.saveUser(user);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<User> update(@PathVariable(value = "id") Long userId,
						@RequestBody User userDetails) throws ResourceNotFoundException {
		User user = userService.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User not found : " + userId));
		user.setName(userDetails.getName());
		user.setEmail(userDetails.getEmail());
		user.setPhone(userDetails.getPhone());
		userService.saveUser(user);
		User updatedUser = userService.saveUser(user);
		return ResponseEntity.ok(updatedUser);
	}

	@DeleteMapping("/delete/{id}")
	public Map<String, Boolean> delete(@PathVariable(value = "id") long userId) throws Exception {
		User user = userService.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User not found: " + userId));
		userService.deleteUser(userId);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
