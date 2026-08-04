package ir.maktabsharif.repository;

import java.util.List;

public interface GenericRepository<T >{
    T save (T entity);
    T update (T entity);
    T findById (long id);
    //???
    void delete(long id);
    List<T> findAll();
}
