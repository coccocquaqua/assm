package com.example.assm.service.user.account;

import com.example.assm.entity.User;
import com.example.assm.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService implements IAccountService{
    @Autowired
    public AccountRepository repository;
    @Override
    public List<User> getAllUser(){
        List<User>  userList =repository.findAll();
        return userList;
    }
    @Override
    public Optional<User> getUserById(int id){
        Optional<User> user=repository.findById(id);
        return user;
    }
    @Override
    public void saveAccount(User user) {
        repository.save(user);
    }
}
