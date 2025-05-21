package ss10.repository;

import ss10.model.Fruit;

import java.util.ArrayList;
import java.util.List;

public class FruitRepository implements IFruitRepository{
    private final List<Fruit> fruitList = new ArrayList<>();

    @Override
    public List<Fruit> getAll() {
        return fruitList;
    }

    @Override
    public void add(Fruit fruit) {
        fruitList.add(fruit);
    }
}
