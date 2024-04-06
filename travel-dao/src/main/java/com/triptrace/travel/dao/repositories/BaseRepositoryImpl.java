package com.triptrace.travel.dao.repositories;

import jakarta.persistence.EntityManager;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

/**
 * Base repository for repository framework
 * @param <T>
 * @param <ID>
 */
public class BaseRepositoryImpl<T,ID extends Serializable> extends SimpleJpaRepository<T,ID> implements BaseRepository<T,ID> {

    private final EntityManager entityManager;

    public BaseRepositoryImpl(JpaEntityInformation<T,?> entityInformation, EntityManager entityManager){
        super(entityInformation, entityManager);
        this.entityManager=entityManager;
    }


    @Override
    @Transactional
    public void refresh(T t) {
        entityManager.refresh(t);
    }

    @Override
    public T findOne(ID id) {
        return super.findById(id).orElse(null);
    }

    @Override
    public List<T> findAll(List<ID> ids) {
        return super.findAllById(ids);
    }
}
