package casestudy.service;

import casestudy.model.Trainer;
import casestudy.repository.ITrainerRepository;
import casestudy.repository.TrainerRepository;

import java.util.List;

public class TrainerService implements ITrainerService{
    private final ITrainerRepository trainerRepository = new TrainerRepository();

    @Override
    public List<Trainer> findAll() {
        return trainerRepository.findAll();
    }

    @Override
    public boolean add(Trainer trainer) {
        return trainerRepository.add(trainer);
    }

    @Override
    public boolean delete(String id) {
        return false;
    }

    @Override
    public boolean update(String id, Trainer trainer) {
        return false;
    }

    @Override
    public Trainer findById(String id) {
        return null;
    }
}
