package ss13.service;

import java.util.List;

public interface IExpenditureService<T> {
    List<T> getAll();
    boolean add(T t);
    boolean delete(String id);
    boolean update(String id, T t);
    T findById(String id);
    List<T> searchByName(String name);
    List<T> sortByName();
    List<T> sortByAmount();
}
