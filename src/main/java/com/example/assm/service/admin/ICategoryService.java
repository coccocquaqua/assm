package com.example.assm.service.admin;

import com.example.assm.entity.Category;
import com.example.assm.repository.CategoryRepository;

public interface ICategoryService extends CategoryRepository {
    Category findById(int id);
}
