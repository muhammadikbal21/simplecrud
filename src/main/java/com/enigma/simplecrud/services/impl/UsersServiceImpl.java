package com.enigma.simplecrud.services.impl;

import com.enigma.simplecrud.entities.Users;
import com.enigma.simplecrud.repositories.UsersRepository;
import com.enigma.simplecrud.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersServiceImpl extends CommonServiceImpl<Users, Integer> implements UsersService {

    @Autowired
    public UsersServiceImpl(UsersRepository repository) {
        super(repository);
    }
}

