package com.acmeflix.service;

import com.acmeflix.domain.Category;
import com.acmeflix.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryServiceImplementation extends BaseServiceImpl<T>
        implements CategoryService {

    private final CategoryRepository categoryRepository;

    JpaRepository<T, Long> getRepository() { return categoryRepository;}

    @Override
    public Category findByDescription(String description) {
        return null;
    }

    @Override
    public Page<Category> findAll(Pageable pageable) {
        return null;
    }
}
