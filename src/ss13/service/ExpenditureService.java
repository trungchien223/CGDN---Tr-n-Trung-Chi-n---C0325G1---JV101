package ss13.service;

import ss13.model.Expenditure;
import ss13.repository.ExpenditureRepository;
import ss13.repository.IExpenditureRepository;
import ss13.utils.IdNotFoundException;
import ss13.utils.UniqueIdException;

import java.util.List;

public class ExpenditureService implements IExpenditureService<Expenditure> {
    private final IExpenditureRepository<Expenditure> expenditureRepository = new ExpenditureRepository();

    @Override
    public List<Expenditure> getAll() {
        return expenditureRepository.findAll();
    }

    @Override
    public void add(Expenditure expenditure) throws UniqueIdException{
        expenditureRepository.add(expenditure);
    }

    @Override
    public void delete(String id) throws IdNotFoundException {
        expenditureRepository.delete(id);
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
    public List<Expenditure> searchByName(String name) {
        return expenditureRepository.searchByName(name);
    }

    @Override
    public List<Expenditure> sortByName() {
        return expenditureRepository.sortByName();
    }

    @Override
    public List<Expenditure> sortByAmount() {
        return expenditureRepository.sortByAmount();
    }
}
