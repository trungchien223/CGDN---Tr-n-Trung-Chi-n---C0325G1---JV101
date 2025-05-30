package ss13.repository;

import ss13.model.Expenditure;
import ss13.utils.ReadAndWrite;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ExpenditureRepository implements IExpenditureRepository<Expenditure> {
//    private static final String FILE_PATH = "src/ss13/data/expenditure.csv";

//    @Override
//    public List<Expenditure> findAll() {
//        List<String> lines = ReadAndWrite.readFile(FILE_PATH);
//        List<Expenditure> expenditures = new ArrayList<>();
//        for (String line : lines) {
//            String[] array = line.split(",");
//            expenditures.add(new Expenditure(array[0], array[1], array[2], Double.parseDouble(array[3]), array[4]));
//        }
//        return expenditures;
//    }
//
//    @Override
//    public boolean add(Expenditure expenditure) {
//        List<String> data = new ArrayList<>();
//        data.add(expenditure.toCSV());
//        ReadAndWrite.writeFile(FILE_PATH, data, true);
//        return true;
//    }
//
//    @Override
//    public boolean delete(String id) {
//        List<String> lines = ReadAndWrite.readFile(FILE_PATH);
//        List<String> newLines = new ArrayList<>();
//        for (String line : lines) {
//            String[] array = line.split(",");
//            if (!array[0].equals(id)) {
//                newLines.add(line);
//            }
//        }
//        ReadAndWrite.writeFile(FILE_PATH, newLines, false);
//        return true;
//    }
//
//    @Override
//    public boolean update(String id, Expenditure expenditure) {
//        List<String> lines = ReadAndWrite.readFile(FILE_PATH);
//        List<String> newLines = new ArrayList<>();
//        boolean found = false;
//        for (String line : lines) {
//            String[] array = line.split(",");
//            if (array[0].equals(id)) {
//                newLines.add(expenditure.toCSV());
//                found = true;
//            } else {
//                newLines.add(line);
//            }
//            ReadAndWrite.writeFile(FILE_PATH, newLines, false);
//        }
//        return found;
//    }

    private static final String FILE_PATH = "src/ss13/data/expenditure.dat";

    @Override
    public List<Expenditure> findAll() {
        return ReadAndWrite.readFileToBinary(FILE_PATH);
    }

    @Override
    public boolean add(Expenditure expenditure) {
        List<Expenditure> expenditures = ReadAndWrite.readFileToBinary(FILE_PATH);
        expenditures.add(expenditure);
        ReadAndWrite.writeFileToBinary(FILE_PATH, expenditures);
        return true;
    }

    @Override
    public boolean delete(String id) {
        List<Expenditure> expenditures = ReadAndWrite.readFileToBinary(FILE_PATH);
        boolean removed = expenditures.removeIf(e -> e.getId().equals(id));
        if (removed) {
            ReadAndWrite.writeFileToBinary(FILE_PATH, expenditures);
        }
        return removed;
    }

    @Override
    public boolean update(String id, Expenditure expenditure) {
        List<Expenditure> expenditures = ReadAndWrite.readFileToBinary(FILE_PATH);
        boolean found = false;
        for (int i = 0; i < expenditures.size(); i++) {
            if (expenditures.get(i).getId().equals(id)) {
                expenditures.set(i, expenditure);
                found = true;
                break;
            }
        }
        if (found) {
            ReadAndWrite.writeFileToBinary(FILE_PATH, expenditures);
        }
        return found;
    }

    @Override
    public Expenditure findById(String id) {
        List<Expenditure> expenditures = findAll();
        for (Expenditure expenditure : expenditures) {
            if (expenditure.getId().equals(id)) {
                return expenditure;
            }
        }
        return null;
    }

    @Override
    public List<Expenditure> searchByName(String name) {
        List<Expenditure> result = new ArrayList<>();
        List<Expenditure> expenditures = findAll();
        for (Expenditure expenditure : expenditures) {
            if (expenditure.getName().toLowerCase().contains(name.toLowerCase())) {
                result.add(expenditure);
            }
        }
        return result;
    }

    @Override
    public List<Expenditure> sortByName() {
        List<Expenditure> sortList = new ArrayList<>(findAll());
        sortList.sort(new Comparator<Expenditure>() {
            @Override
            public int compare(Expenditure o1, Expenditure o2) {
                return o1.getName().compareToIgnoreCase(o2.getName());
            }
        });
        return sortList;
    }

    @Override
    public List<Expenditure> sortByAmount() {
        List<Expenditure> sortList = new ArrayList<>(findAll());
        sortList.sort(new Comparator<Expenditure>() {
            @Override
            public int compare(Expenditure o1, Expenditure o2) {
                int reduce = Double.compare(o2.getExpenditureAmount(), o1.getExpenditureAmount());
                if (reduce != 0) {
                    return reduce;
                }
                return o1.getName().compareToIgnoreCase(o2.getName());
            }
        });
        return sortList;
    }

}
