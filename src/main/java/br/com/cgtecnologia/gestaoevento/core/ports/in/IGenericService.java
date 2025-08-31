package br.com.cgtecnologia.gestaoevento.core.ports.in;

import java.util.List;
import java.util.Optional;

public interface IGenericService<T, ID> {
    T save(T coreEntity);
    T update(T coreEntity);
    void deleteById(ID id);
    Optional<T> getById(ID id);
    List<T> getAll();
}
