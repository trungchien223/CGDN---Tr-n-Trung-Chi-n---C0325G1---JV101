package ss10.service;

import ss10.model.Fruit;
import ss10.repository.FruitRepository;
import ss10.repository.IFruitRepository;

import java.util.Map;
import java.util.Set;

public class FruitService implements IFruitService{
    private final IFruitRepository repository = new FruitRepository();

    @Override
    public Set<String> getAllKeys() {
        return repository.getAllKeys();
    }

    @Override
    public Set<Map.Entry<String, Fruit>> getAllEntries() {
        return repository.getAllEntries();
    }

    @Override
    public void add(String code, Fruit fruit) {
        repository.add(code, fruit);
    }

    @Override
    public void remove(String code) {
        repository.remove(code);
    }

    @Override
    public void containsCode(String code) {
        repository.containsCode(code);
    }

    @Override
    public void update(String code, Fruit fruit) {
        repository.update(code, fruit);
    }

    @Override
    public Fruit getByCode(String code) {
        return repository.getByCode(code);
    }
}
