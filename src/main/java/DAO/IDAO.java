package DAO;

import java.util.List;

public interface IDAO<T> {
    List<T> showAll();

    T findById(int id);

    boolean update(T t);

    boolean delete(int id);

    boolean save(T t);

    T findByName(String name);

}
