package br.com.cgtecnologia.gestaoevento.infrastructure.adapters.persistence.repositories;

import br.com.cgtecnologia.gestaoevento.core.ports.out.IGenericRepositoryPort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public abstract class GenericRepositoryPort<T, ID, E> implements IGenericRepositoryPort<T, ID> {

    protected abstract E toJpaEntity(T coreEntity);
    protected abstract T toCoreEntity(E jpaEntity);
    protected abstract JpaRepository<E, ID> getJpaRepository();

    @Override
    public T save(T coreEntity) {
        E jpaEntity = toJpaEntity(coreEntity);
        E savedEntity = getJpaRepository().save(jpaEntity);
        return toCoreEntity(savedEntity);
    }

    public T update(T coreEntity) {
        return save(coreEntity);
    }

    @Override
    public void deleteById(ID id) {
        getJpaRepository().deleteById(id);
    }

    @Override
    public List<T> getAll() {
        return getJpaRepository().findAll().stream()
                .map(this::toCoreEntity)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<T> getById(ID id) {
        return getJpaRepository().findById(id).map(this::toCoreEntity);
    }
}
