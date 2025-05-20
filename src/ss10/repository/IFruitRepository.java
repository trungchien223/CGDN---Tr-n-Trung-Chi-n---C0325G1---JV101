package ss10.repository;

import ss10.model.Fruit;

import java.util.List;

public interface IFruitRepository {
    List<Fruit> getAll();
    void add(Fruit fruit);
}
