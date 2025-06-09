package casestudy.repository;

import casestudy.model.Trainer;

import java.util.ArrayList;
import java.util.List;

public class TrainerRepository implements ITrainerRepository{
    private static final List<Trainer> trainerList = new ArrayList<>();
    static {
        trainerList.add(new Trainer("T1", "Vinh", "Yoga", "0987654321", 28, "Nam", 5));
        trainerList.add(new Trainer("T2", "Nam", "Cardio", "0976543210", 32, "Nam", 7));
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
        Trainer trainer = findById(id);
        if (trainer != null) {
            return trainerList.remove(trainer);
        }
        return false;
    }

    @Override
    public boolean update(String id, Trainer trainer) {
        int index = -1;
        for (int i = 0; i < trainerList.size(); i++) {
            if (trainerList.get(i).getId().equals(id)) {
                index = i;
                break;
            }
        }

        if (index != -1) {
            trainerList.set(index, trainer);
            return true;
        }
        return false;
    }

    @Override
    public Trainer findById(String id) {
        for (Trainer trainer : trainerList) {
            if (trainer.getId().equals(id)) {
                return trainer;
            }
        }
        return null;
    }
}
