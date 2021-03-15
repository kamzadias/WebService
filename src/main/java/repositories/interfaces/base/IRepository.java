package repositories.interfaces.base;

import java.util.List;

public interface IRepository<E> {
    boolean create(E user);

    E get(int id);

    List<E> getAll();

    boolean delete(int id);
}