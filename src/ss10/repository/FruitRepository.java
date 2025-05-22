package ss10.repository;

import ss10.model.Fruit;

import java.util.*;

public class FruitRepository implements IFruitRepository{
    private final Map<String, Fruit> fruitMap = new LinkedHashMap<>();

    @Override
    public Set<String> getAllKeys() {
        return fruitMap.keySet();
    }

    @Override
    public Set<Map.Entry<String, Fruit>> getAllEntries() {
        return fruitMap.entrySet();
    }

    @Override
    public void add(String code, Fruit fruit) {
        fruitMap.put(code, fruit);
    }

    @Override
    public void remove(String code) {
        fruitMap.remove(code);
    }

    @Override
    public void containsCode(String code) {
    }

    @Override
    public void update(String code, Fruit fruit) {
        fruitMap.put(code, fruit);
    }

    @Override
    public Fruit getByCode(String code) {
        return fruitMap.get(code);
    }
}
