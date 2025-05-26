package ss13.repository;

import java.util.List;

public interface IExpenditureRepository<T> {
    List<T> findAll();
    void add(T t);
    boolean delete(String id);
    boolean update(String id, T t);
    T findById(String id);
    List<T> seachByName(String name);
}
