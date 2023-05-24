package com.example.assm.repository;

import com.example.assm.entity.Product;
import com.example.assm.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<User, Integer> {
    Optional<User> findByName(String name);
}
