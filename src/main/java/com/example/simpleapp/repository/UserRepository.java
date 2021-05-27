package com.example.simpleapp.repository;

import com.example.simpleapp.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT u from User u Where u.username = :username")
    public User getUserByUsername(@Param("username") String username);

    
}
