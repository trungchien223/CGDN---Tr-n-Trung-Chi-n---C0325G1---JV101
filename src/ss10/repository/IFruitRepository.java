package ss10.repository;

import ss10.model.Fruit;

import java.util.Map;
import java.util.Set;

public interface IFruitRepository {

    Set<String> getAllKeys();
    Set<Map.Entry<String, Fruit>> getAllEntries();
    void add(String code, Fruit fruit);
    void remove(String code);
    void containsCode(String code);
    void update(String code, Fruit fruit);
    Fruit getByCode(String code);
}
