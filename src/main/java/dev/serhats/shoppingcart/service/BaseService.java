package dev.serhats.shoppingcart.service;

import dev.serhats.shoppingcart.exception.EntityNotFoundException;
import dev.serhats.shoppingcart.model.BaseModel;
import dev.serhats.shoppingcart.model.repo.BaseRepo;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface BaseService<Entity extends BaseModel, Repo extends BaseRepo<Entity>> {
    Repo getRepo();

    @Transactional(readOnly = true)
    default List<Entity> getAll() {
        return getRepo().findAll();
    }

    @Transactional(readOnly = true)
    default Optional<Entity> findById(long entityId) {
        return getRepo().findById(entityId);
    }

    @Transactional(readOnly = true)
    default Entity getById(long entityId) throws EntityNotFoundException {
        return getRepo().findById(entityId).orElseThrow(EntityNotFoundException::new);
    }

    @Transactional
    default Entity save(Entity entity) {
        return getRepo().save(entity);
    }

    @Transactional
    default void delete(Entity entity) throws EntityNotFoundException {
        getRepo().delete(entity);
    }

    @Transactional
    default void delete(long entityId) throws EntityNotFoundException {
        Entity entity = getById(entityId);
        getRepo().delete(entity);
    }

}
