package com.acmeflix.service;

import java.util.List;

public interface BaseService<T, ID> {

    T create(T element);

    List<T> createAll(T... element);

    List<T> createAll(List<T> element);

    void update(T element);

    void delete(T element);

    void deleteById(ID id);

    boolean exists(T element);

    List<T> findAll();

    T find(Long id);

    T get(Long id);
}
