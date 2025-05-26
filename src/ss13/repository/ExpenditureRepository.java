package ss13.repository;

import ss13.model.Expenditure;

import java.util.ArrayList;
import java.util.List;

public class ExpenditureRepository implements IExpenditureRepository<Expenditure>{
    private static final List<Expenditure> expenditures = new ArrayList<>();
    static {
        expenditures.add(new Expenditure("C03", "Mua sắm", "01-01-2025", 500000, "Đồ điện tử"));
    }

    @Override
    public List<Expenditure> findAll() {
        return expenditures;
    }

    @Override
    public void add(Expenditure expenditure) {
        expenditures.add(expenditure);
    }

    @Override
    public boolean delete(String id) {
        for (int i = 0; i < expenditures.size();i++){
            if (expenditures.get(i).getId().equals(id)){
                expenditures.remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean update(String id, Expenditure expenditure) {
        for (int i = 0; i < expenditures.size(); i++) {
            if (expenditures.get(i).getId().equals(id)){
                expenditures.set(i,expenditure);
                return true;
            }
        }
        return false;
    }

    @Override
    public Expenditure findById(String id) {
        for(Expenditure expenditure : expenditures){
            if (expenditure.getId().equals(id)){
                return expenditure;
            }
        }
        return null;
    }

    @Override
    public List<Expenditure> seachByName(String name) {
        List<Expenditure> result = new ArrayList<>();
        for (Expenditure expenditure : expenditures){
            if (expenditure.getName().toLowerCase().contains(name.toLowerCase())){
                result.add(expenditure);
            }
        }
        return result;
    }
}
