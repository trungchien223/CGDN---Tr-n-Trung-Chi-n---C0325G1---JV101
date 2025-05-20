package ss10.service;

import ss10.model.Fruit;

import java.util.List;

public interface IFruitService {
    List<Fruit> getAll();
    void add(Fruit fruit);
}
