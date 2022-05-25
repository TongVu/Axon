package com.example.demo.services;

import com.example.demo.data.UserDTO;
import com.example.demo.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;
import java.util.Optional;

public interface UserService {
    public abstract List<User> getAllUser();


    public abstract User saveUser(User user);

    public abstract void deleteUser(Long id) ;

    public abstract Optional<User> findById(Long id);
    public abstract User findByName(String name);

    public abstract Page<User> findPaginated(int pageNo, int pageSize);

    public abstract List<User> searchUser(String keyword);

    public abstract User toUserEntity(UserDTO userDTO);
    public abstract List<User> toUserEntity(List<UserDTO> userDTOs);

    public abstract List<UserDTO> toUserDTO(List<User> users);
    public abstract UserDTO toUserDTO(User user);

}
