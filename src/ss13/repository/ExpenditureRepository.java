package ss13.repository;

import ss13.model.Expenditure;
import ss13.utils.IdNotFoundException;
import ss13.utils.UniqueIdException;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ExpenditureRepository implements IExpenditureRepository<Expenditure>{
    private static final List<Expenditure> expenditures = new ArrayList<>();
    static {
        expenditures.add(new Expenditure("C03", "Mua sam", "01-01-2025", 500000, "Đồ điện tử"));
        expenditures.add(new Expenditure("C04", "Đi choi", "21-04-2025", 1000000, "Hội An"));
        expenditures.add(new Expenditure("C05", "An uong", "14-06-2025", 700000, "Đồ ăn Hàn Quốc"));
    }

    @Override
    public List<Expenditure> findAll() {
        return expenditures;
    }

    @Override
    public void add(Expenditure expenditure) throws UniqueIdException {
        for (Expenditure e : expenditures){
            if (e.getId().equals(expenditure.getId())){
                throw new UniqueIdException("Mã chi tiêu đã tồn tại: " + expenditure.getId());
            }
        }
        expenditures.add(expenditure);
    }

    @Override
    public void delete(String id) throws IdNotFoundException{
        for (int i = 0; i < expenditures.size(); i++) {
            if (expenditures.get(i).getId().equals(id)) {
                expenditures.remove(i);
                return;
            }
        }
        throw new IdNotFoundException("Không tìm thấy mã chi tiêu: " + id);
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
    public List<Expenditure> searchByName(String name) {
        List<Expenditure> result = new ArrayList<>();
        for (Expenditure expenditure : expenditures){
            if (expenditure.getName().toLowerCase().contains(name.toLowerCase())){
                result.add(expenditure);
            }
        }
        return result;
    }

    @Override
    public List<Expenditure> sortByName() {
        List<Expenditure> sortList = new ArrayList<>(expenditures);

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
        List<Expenditure> sortList = new ArrayList<>(expenditures);
        sortList.sort(new Comparator<Expenditure>() {
            @Override
            public int compare(Expenditure o1, Expenditure o2) {
                int reduce = Double.compare(o2.getExpenditureAmount(),o1.getExpenditureAmount());
                if (reduce!=0){
                    return reduce;
                }
                return o1.getName().compareToIgnoreCase(o2.getName());
            }
        });
        return sortList;
    }
}
