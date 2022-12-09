package com.spring.mvc.service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface IService<T, K> {
    List<T> getAll();

    Optional<T> getByID(K id);

    T save(T entity);

    void delete(K id);
}
