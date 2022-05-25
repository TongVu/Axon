package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.User;



@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	@Query(value = "SELECT id, name, email, phone FROM users u WHERE CONCAT(u.id, ' ',u.name, ' ', u.email, ' ', u.phone) LIKE %?1%"
			, nativeQuery = true)
	public List<User> search(String pageable);
	public User findByName(String name);
}