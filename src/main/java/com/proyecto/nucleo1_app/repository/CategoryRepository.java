package com.proyecto.nucleo1_app.repository;

import com.proyecto.nucleo1_app.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
