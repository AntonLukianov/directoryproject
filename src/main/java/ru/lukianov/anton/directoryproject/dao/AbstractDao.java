package ru.lukianov.anton.directoryproject.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.util.List;

/**
 * {@inheritDoc}
 */
public abstract class AbstractDao<T extends Serializable, ID extends Number> implements IGenericDao<T, ID> {

    private Class<T> clazz;

    @PersistenceContext
    private EntityManager entityManager;

    /**
     * {@inheritDoc}
     */
    public void setClazz(Class<T> clazzToSet) {
        this.clazz = clazzToSet;
    }

    /**
     * {@inheritDoc}
     */
    public List<T> all() {
        return entityManager.createQuery("from " + clazz.getName()).getResultList();
    }

    /**
     * {@inheritDoc}
     */
    public T loadById(ID id) {
        return entityManager.find(clazz, id);
    }

    /**
     * {@inheritDoc}
     */
    public void update(T entity) {
        entityManager.persist(entity);
    }

    /**
     * {@inheritDoc}
     */
    public void save(T entity) {
        entityManager.persist(entity);
    }

}
