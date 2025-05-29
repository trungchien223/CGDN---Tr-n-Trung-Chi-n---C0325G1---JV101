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
    public boolean add(Expenditure expenditure) {
        try {
            List<Expenditure> expenditures = expenditureRepository.findAll();
            for (Expenditure e : expenditures) {
                if (e.getId().equals(expenditure.getId())) {
                    throw new UniqueIdException("Mã chi tiêu đã tồn tại: " + expenditure.getId());
                }
            }
            return expenditureRepository.add(expenditure);
        } catch (UniqueIdException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean delete(String id) {
        try {
            Expenditure expenditure = expenditureRepository.findById(id);
            if (expenditure == null) {
                throw new IdNotFoundException("Không tìm thấy mã chi tiêu: " + id);
            }
            return expenditureRepository.delete(id);
        } catch (IdNotFoundException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean update(String id, Expenditure expenditure) {
        try {
            Expenditure e = expenditureRepository.findById(id);
            if (e == null) {
                throw new IdNotFoundException("Không tìm thấy mã chi tiêu: " + id);
            }
            return expenditureRepository.update(id, expenditure);
        } catch (IdNotFoundException e) {
            System.out.println(e.getMessage());
            return false;
        }
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
