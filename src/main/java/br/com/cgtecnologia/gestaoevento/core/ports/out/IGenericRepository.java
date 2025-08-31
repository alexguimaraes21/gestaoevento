package br.com.cgtecnologia.gestaoevento.core.ports.out;

import java.util.List;
import java.util.Optional;

public interface IGenericRepository<T, ID> {
    T save(T coreEntity);
    T update(T coreEntity);
    void deleteById(ID id);
    List<T> getAll();
    Optional<T> getById(ID id);
}
