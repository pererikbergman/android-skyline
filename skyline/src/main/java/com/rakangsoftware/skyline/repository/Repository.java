package com.rakangsoftware.skyline.repository;

import java.util.List;

import io.reactivex.Observable;

public interface Repository<T, K> {

    Observable<List<T>> get();

    Observable<T> getById(K id);

    Observable<T> create(T entity);

    Observable<T> update(T entity);

    Observable<T> delete(T entity);

}