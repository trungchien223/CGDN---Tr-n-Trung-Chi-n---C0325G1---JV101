package casestudy.service;

import casestudy.model.Trainer;
import casestudy.repository.ITrainerRepository;
import casestudy.repository.TrainerRepository;
import casestudy.utils.DuplicateIdException;
import casestudy.utils.IdNotFoundException;

import java.util.List;

public class TrainerService implements ITrainerService {
    private final ITrainerRepository trainerRepository = new TrainerRepository();

    @Override
    public List<Trainer> findAll() {
        return trainerRepository.findAll();
    }

    @Override
    public boolean add(Trainer trainer) {
        try {
            List<Trainer> trainers = trainerRepository.findAll();
            for (Trainer t : trainers) {
                if (t.getId().equals(trainer.getId())) {
                    throw new DuplicateIdException("ID huấn luyện viên đã tồn tại: " + trainer.getId());
                }
            }
            return trainerRepository.add(trainer);
        } catch (DuplicateIdException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean delete(String id) {
        try {
            Trainer trainer = trainerRepository.findById(id);
            if (trainer == null) {
                throw new IdNotFoundException("Không tìm thấy huấn luyện viên với ID: " + id);
            }
            return trainerRepository.delete(id);
        } catch (IdNotFoundException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean update(String id, Trainer trainer) {
        try {
            Trainer existingTrainer = trainerRepository.findById(id);
            if (existingTrainer == null) {
                throw new IdNotFoundException("Không tìm thấy huấn luyện viên với ID: " + id);
            }
            return trainerRepository.update(id, trainer);
        } catch (IdNotFoundException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public Trainer findById(String id) {
        return trainerRepository.findById(id);
    }
}
