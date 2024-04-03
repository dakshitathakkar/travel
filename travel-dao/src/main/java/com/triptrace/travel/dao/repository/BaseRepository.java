package com.triptrace.travel.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;
import java.util.List;

@NoRepositoryBean
public interface BaseRepository<T, ID extends Serializable> extends JpaRepository<T,ID>, JpaSpecificationExecutor<T> {
    void refresh(T t);

    T findOne(ID id);

    List<T> findAll(List<ID> ids);
}