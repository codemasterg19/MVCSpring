package com.proyecto.nucleo1_app.services;


import com.proyecto.nucleo1_app.models.Category;
import com.proyecto.nucleo1_app.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    //obtener la lista de categorias
    public List<Category> getAllCategories(){
        return categoryRepository.findAll();
    }
}
