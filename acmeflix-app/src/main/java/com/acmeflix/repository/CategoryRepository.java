package com.acmeflix.repository;

import com.acmeflix.domain.enumeration.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category findByDescription(String description);
}
