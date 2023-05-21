package com.example.assm.service.user.account;

import com.example.assm.entity.User;

import java.util.List;
import java.util.Optional;

public interface IAccountService {
    List<User> getAllUser();
    Optional<User> getUserById(int id);
}
