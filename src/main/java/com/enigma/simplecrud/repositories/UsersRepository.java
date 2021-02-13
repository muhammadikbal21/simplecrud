package com.enigma.simplecrud.repositories;

import com.enigma.simplecrud.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, Integer> {
    Boolean existsByUsername(String username);
    Users findByUsername(String username);
}
