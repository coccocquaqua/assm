package com.example.assm.service.admin;

import com.example.assm.entity.Category;
import com.example.assm.entity.Product;
import com.example.assm.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryService implements ICategoryService{
    @Autowired
    CategoryRepository categoryRepository;
    @Override
    public Category findById(int id) {
            Optional<Category> optional = categoryRepository.findById(id);//xử lí vấn đề null
            Category category = null;
            if (optional.isPresent()) { // ispresent  có giá trị,
                category = optional.get();
            } else {
                System.out.println("category" + id);
            }

            return category;
        }
}
