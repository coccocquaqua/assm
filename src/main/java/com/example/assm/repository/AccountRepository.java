package com.example.assm.repository;

import com.example.assm.entity.Product;
import com.example.assm.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<User, Integer> {
}
