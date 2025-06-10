package casestudy.repository;

import casestudy.model.Trainer;
import casestudy.utils.ReadAndWriteFile;

import java.util.ArrayList;
import java.util.List;

public class TrainerRepository implements ITrainerRepository{
    private static final String FILE_PATH = "src/casestudy/data/trainer.csv";

    @Override
    public List<Trainer> findAll() {
        List<String> lines = ReadAndWriteFile.readFile(FILE_PATH);
        List<Trainer> trainers = new ArrayList<>();
        for (String line : lines) {
            String[] array = line.split(",");
            if (array.length >= 7) {
                Trainer trainer = new Trainer(
                        array[0],
                        array[1],
                        array[2],
                        array[3],
                        Integer.parseInt(array[4]),
                        array[5],
                        Integer.parseInt(array[6])
                );
                trainers.add(trainer);
            }
        }
        return trainers;
    }

    @Override
    public boolean add(Trainer trainer) {
        List<String> lines = new ArrayList<>();
        lines.add(trainer.toCSV());
        ReadAndWriteFile.writeFile(FILE_PATH, lines, true);
        return true;
    }

    @Override
    public boolean delete(String id) {
        List<Trainer> trainers = findAll();
        List<String> newLines = new ArrayList<>();
        boolean isDeleted = false;

        for (Trainer trainer : trainers) {
            if (!trainer.getId().equals(id)) {
                newLines.add(trainer.toCSV());
            } else {
                isDeleted = true;
            }
        }

        if (isDeleted) {
            ReadAndWriteFile.writeFile(FILE_PATH, newLines, false);
        }

        return isDeleted;
    }

    @Override
    public boolean update(String id, Trainer trainer) {
        List<Trainer> trainers = findAll();
        List<String> newLines = new ArrayList<>();
        boolean found = false;

        for (Trainer t : trainers) {
            if (t.getId().equals(id)) {
                newLines.add(trainer.toCSV());
                found = true;
            } else {
                newLines.add(t.toCSV());
            }
        }

        ReadAndWriteFile.writeFile(FILE_PATH, newLines, false);
        return found;
    }

    @Override
    public Trainer findById(String id) {
        List<Trainer> trainers = findAll();
        for (Trainer trainer : trainers) {
            if (trainer.getId().equals(id)) {
                return trainer;
            }
        }
        return null;
    }
}
