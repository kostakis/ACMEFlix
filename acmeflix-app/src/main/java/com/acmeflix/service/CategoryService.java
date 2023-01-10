package com.acmeflix.service;

import com.acmeflix.domain.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CategoryService extends BaseService<Category, Long> {
    Category findByDescription(String description);

    Page<Category> findAll(Pageable pageable);

}
