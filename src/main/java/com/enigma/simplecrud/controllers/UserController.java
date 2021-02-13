package com.enigma.simplecrud.controllers;

import com.enigma.simplecrud.entities.Users;
import com.enigma.simplecrud.repositories.UsersRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.ValidationException;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

@RestController
@RequestMapping("/register") // buat register
public class UserController {

    private UsersRepository usersRepository;


    public UserController(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }


    @PostMapping
    public Boolean create(@RequestBody Map<String, String> body) throws NoSuchAlgorithmException {
        String username = body.get("username");
        if (usersRepository.existsByUsername(username)) {
            throw new ValidationException("Username already existed");
        }

        String password = body.get("password");
        String encodedPassword = new BCryptPasswordEncoder().encode(password);
//        String hashedPassword = hashData.get_SHA_512_SecurePassword(password);
        String fullname = body.get("fullname");
        usersRepository.save(new Users(username, encodedPassword, fullname));
        return true;
    }

}