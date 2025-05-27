package ss13.service;

import ss13.utils.IdNotFoundException;
import ss13.utils.UniqueIdException;

import java.util.List;

public interface IExpenditureService<T> {
    List<T> getAll();
    void add(T t) throws UniqueIdException;
    void delete(String id) throws IdNotFoundException;
    boolean update(String id, T t);
    T findById(String id);
    List<T> searchByName(String name);
    List<T> sortByName();
    List<T> sortByAmount();
}
