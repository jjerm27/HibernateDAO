package services;

import java.util.List;

public interface CommonService<T> {
    T find(int id);

    void save(T obj);

    void delete(T obj);

    void update(T obj);

    List<T> getAll();
}
