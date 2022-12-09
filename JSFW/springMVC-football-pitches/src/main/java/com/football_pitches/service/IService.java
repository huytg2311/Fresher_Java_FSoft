package com.football_pitches.service;

import java.util.List;
import java.util.Optional;
/*
 * Account: HuyTG8
 * Birthday: 2001/11/23
 * */
public interface IService<T, K> {
    List<T> getAll();

    Optional<T> getByID(K id);

    T save(T entity);

    void delete(K id);
}
