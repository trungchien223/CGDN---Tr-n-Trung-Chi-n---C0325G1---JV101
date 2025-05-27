package ss13.repository;

import ss13.utils.IdNotFoundException;
import ss13.utils.UniqueIdException;

import java.util.List;

public interface IExpenditureRepository<T> {
    List<T> findAll();
    void add(T t) throws UniqueIdException;
    void delete(String id) throws IdNotFoundException;
    boolean update(String id, T t);
    T findById(String id);
    List<T> searchByName(String name);
    List<T> sortByName();
    List<T> sortByAmount();
}
