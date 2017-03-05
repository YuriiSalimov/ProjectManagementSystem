package com.management.project.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

/**
 * Created by Perevoznyk Pavel on 07.02.2017.
 * V 1.0a
 */
public interface GenericDAO<T, ID extends Serializable> {

    ID save(T obj);

    T findById(ID id);

    void update(T obj);

    void delete(T obj);

    List<T> findAll();
}
