package ss13.service;

import ss13.model.Expenditure;
import ss13.repository.ExpenditureRepository;
import ss13.repository.IExpenditureRepository;

import java.util.List;

public class ExpenditureService implements IExpenditureService<Expenditure> {
    private final IExpenditureRepository<Expenditure> expenditureRepository = new ExpenditureRepository();

    @Override
    public List<Expenditure> getAll() {
        return expenditureRepository.findAll();
    }

    @Override
    public void add(Expenditure expenditure) {
        expenditureRepository.add(expenditure);
    }

    @Override
    public boolean delete(String id) {
        return expenditureRepository.delete(id);
    }

    @Override
    public boolean update(String id, Expenditure expenditure) {
        return expenditureRepository.update(id, expenditure);
    }

    @Override
    public Expenditure findById(String id) {
        return expenditureRepository.findById(id);
    }

    @Override
    public List<Expenditure> seachByName(String name) {
        return expenditureRepository.seachByName(name);
    }
}
