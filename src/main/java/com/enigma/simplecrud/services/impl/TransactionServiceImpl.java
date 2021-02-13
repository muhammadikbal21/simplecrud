package com.enigma.simplecrud.services.impl;

import com.enigma.simplecrud.entities.Transaction;
import com.enigma.simplecrud.repositories.TransactionRepository;
import com.enigma.simplecrud.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class TransactionServiceImpl extends CommonServiceImpl<Transaction, Integer> implements TransactionService {

    @Autowired
    public TransactionServiceImpl(TransactionRepository repository) {

        super(repository);
    }
}
