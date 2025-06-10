package casestudy.controller;

import casestudy.model.Trainer;
import casestudy.service.ITrainerService;
import casestudy.service.TrainerService;

import java.util.List;

public class TrainerController {
    private final ITrainerService trainerService = new TrainerService();

    public List<Trainer> getAllTrainers() {
        return trainerService.findAll();
    }

    public boolean addTrainer(Trainer trainer) {
        return trainerService.add(trainer);
    }

    public boolean updateTrainer(String id, Trainer trainer) {
        return trainerService.update(id, trainer);
    }

    public boolean deleteTrainer(String id) {
        return trainerService.delete(id);
    }

    public Trainer findTrainerById(String id) {
        return trainerService.findById(id);
    }
}
