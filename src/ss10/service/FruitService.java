package ss10.service;

import ss10.model.Fruit;
import ss10.repository.FruitRepository;
import ss10.repository.IFruitRepository;

import java.util.List;

public class FruitService implements IFruitService{
    private final IFruitRepository repository = new FruitRepository();
    @Override
    public List<Fruit> getAll() {
        return repository.getAll();
    }

    @Override
    public void add(Fruit fruit) {
        repository.add(fruit);
    }
}
