package ir.maktabsharif.service;

import ir.maktabsharif.exception.BookNotFoundException;

import java.util.List;

public interface GenericService <T>{
    void save(T entity) throws BookNotFoundException;
    T update(T entity) throws BookNotFoundException;
    T findById(long id);
    long delete(long id);
    List<T> findAll();
}
