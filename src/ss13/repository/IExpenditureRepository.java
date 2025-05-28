package ss13.repository;

import java.util.List;

public interface IExpenditureRepository<T> {
    List<T> findAll();
    boolean add(T t);
    boolean delete(String id);
    boolean update(String id, T t);
    T findById(String id);
    List<T> searchByName(String name);
    List<T> sortByName();
    List<T> sortByAmount();
}
