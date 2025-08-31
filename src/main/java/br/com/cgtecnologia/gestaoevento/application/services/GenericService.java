package br.com.cgtecnologia.gestaoevento.application.services;


import br.com.cgtecnologia.gestaoevento.core.ports.in.IGenericService;
import br.com.cgtecnologia.gestaoevento.core.ports.out.IGenericRepository;

import java.util.List;
import java.util.Optional;

public abstract class GenericService<T, ID, R extends IGenericRepository<T, ID>> implements IGenericService<T, ID> {

    protected final R repository;

    public GenericService() {
        this.repository = null;
    }

    public GenericService(R repository) {
        this.repository = repository;
    }

    @Override
    public T save(T coreEntity) {
        return repository.save(coreEntity);
    }

    @Override
    public T update(T coreEntity) {
        return repository.update(coreEntity);
    }

    @Override
    public void deleteById(ID id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<T> getById(ID id) {
        return repository.getById(id);
    }

    @Override
    public List<T> getAll() {
        return repository.getAll();
    }
}
