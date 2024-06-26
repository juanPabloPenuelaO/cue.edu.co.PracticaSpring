package repository;

import mapping.dtos.userDTO;
import model.Reservations;

import java.util.List;
public interface RepositoryGeneral<T> {

    List<T> list();
    T byId(int id);
    void save(T t);
    void delete(int id);

    void update(Reservations reservation);
}
