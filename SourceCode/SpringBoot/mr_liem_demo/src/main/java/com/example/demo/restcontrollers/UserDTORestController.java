package com.example.demo.restcontrollers;

import com.example.demo.data.UserDTO;
import com.example.demo.entities.User;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(maxAge = 3600)
@RequestMapping("/api/userDTO")
public class UserDTORestController {
    @Autowired
    private UserServiceImpl userService;

    /**
     * Get all users list.
     *
     * @return the list
     */
    @GetMapping("/list")
    public List<UserDTO> getAll() {
        return userService.toUserDTO(userService.getAllUser());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable(value = "id") Long userId)
            throws ResourceNotFoundException {
        User user = userService.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found on: " + userId));

        return ResponseEntity.ok().body(userService.toUserDTO(user));
    }

    @GetMapping("/query")
    public ResponseEntity<UserDTO> requestParamExample(@RequestParam String name) {
            User user = userService.findByName(name);
            return ResponseEntity.ok().body(userService.toUserDTO(user));
    }


    @PostMapping("/query")
    public ResponseEntity<UserDTO> requestParamPostExample(@RequestParam String name) {
        User user = userService.findByName(name);
        return ResponseEntity.ok().body(userService.toUserDTO(user));
    }
    /**
     * Create user user.
     *
     * @param userDTO the user
     * @return the user
     */
    @PostMapping("/add")
    public User create(@RequestBody UserDTO userDTO) {
        return userService.saveUser(userService.toUserEntity(userDTO));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<UserDTO> update(@PathVariable(value = "id") Long userId,
                                       @RequestBody UserDTO userDetails) throws ResourceNotFoundException {
        User user = userService.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found : " + userId));
        user.setName(userDetails.getName());
        user.setEmail(userDetails.getEmail());
        user.setPhone(userDetails.getPhone());
        userService.saveUser(user);
        User updatedUser = userService.saveUser(user);
        return ResponseEntity.ok(userService.toUserDTO(updatedUser));
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
