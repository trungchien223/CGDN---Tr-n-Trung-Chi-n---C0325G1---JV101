package casestudy.repository;

import casestudy.model.Trainer;

import java.util.List;

public interface ITrainerRepository {
    List<Trainer> findAll();
    boolean add(Trainer trainer);
    boolean delete(String id);
    boolean update(String id, Trainer trainer);
    Trainer findById(String id);
}
