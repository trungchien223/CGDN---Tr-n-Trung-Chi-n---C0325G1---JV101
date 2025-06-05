package casestudy.service;

import casestudy.model.Trainer;

import java.util.List;

public interface ITrainerService {
    List<Trainer> findAll();
    boolean add(Trainer trainer);
    boolean delete(String id);
    boolean update(String id, Trainer trainer);
    Trainer findById(String id);
}
