package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.demo.data.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.demo.entities.User;
import com.example.demo.repositories.UserRepository;



@Service
public class UserServiceImpl {

	@Autowired
	private UserRepository userRepository;

	public List<User> getAllUser() {
		return (List<User>) userRepository.findAll();
	}

	public User saveUser(User user) {

		return userRepository.save(user);
	}

	public void deleteUser(Long id) {
		userRepository.deleteById(id);
	}

	public Optional<User> findById(Long id) {
		return userRepository.findById(id);
	}

	public User findByName(String name){
		return userRepository.findByName(name);
	}

	public Page<User> findPaginated(int pageNo, int pageSize) {
		PageRequest pageable = PageRequest.of(pageNo - 1, pageSize);
		return this.userRepository.findAll(pageable);
	}

	public List<User> searchUser(String keyword) {
		return userRepository.search(keyword);
	}

	public User toUserEntity(UserDTO userDTO){
		return new User(userDTO.getId(), userDTO.getName(), userDTO.getEmail(),
				userDTO.getPhone());

	}
	public List<User> toUserEntity(List<UserDTO> userDTOs){
		List<User> userList = new ArrayList<>();
		for(UserDTO userDTO:userDTOs){
			userList.add(this.toUserEntity(userDTO));
		}
		return userList;
	}
	public  UserDTO toUserDTO(User user){
		return new UserDTO(user.getId(), user.getName(), user.getEmail(), user.getPhone());
	}
	public  List<UserDTO> toUserDTO(List<User> users){
		List<UserDTO> userDTOList = new ArrayList<>();
		for(User user:users)
			userDTOList.add(this.toUserDTO(user));
		return userDTOList;
	}
}
