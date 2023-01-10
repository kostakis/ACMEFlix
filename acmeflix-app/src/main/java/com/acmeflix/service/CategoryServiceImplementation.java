package com.acmeflix.service;

import com.acmeflix.domain.Category;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public abstract class CategoryServiceImplementation extends BaseServiceImpl<Category>
        implements CategoryService {

    JpaRepository<Category, Long> getRepository() { return null;}

}
