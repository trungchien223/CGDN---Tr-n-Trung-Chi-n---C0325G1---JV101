package casestudy.repository;

import casestudy.model.Trainer;

import java.util.ArrayList;
import java.util.List;

public class TrainerRepository implements ITrainerRepository{
    private static final List<Trainer> trainerList = new ArrayList<>();
    private static final TrainerRepository instance = new TrainerRepository();

    private TrainerRepository() {
    }

    public static TrainerRepository getInstance() {
        return instance;
    }

    @Override
    public List<Trainer> findAll() {
        return new ArrayList<>(trainerList);
    }

    @Override
    public boolean add(Trainer trainer) {
        if (findById(trainer.getId()) != null) {
            return false;
        }
        return trainerList.add(trainer);
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
