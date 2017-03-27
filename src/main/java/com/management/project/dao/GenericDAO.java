package com.management.project.dao;

import java.io.Serializable;
import java.util.List;

/**
 * DESCRIPTION - ???
 *
 * @author Perevoznyk Pavel
 */
public interface GenericDAO<T, ID extends Serializable> {

    /**
     *
     * @param obj
     * @return
     */
    ID save(T obj);

    /**
     *
     * @param id
     * @return
     */
    T findById(ID id);

    /**
     *
     * @param obj
     */
    void update(T obj);

    /**
     *
     * @param obj
     */
    void delete(T obj);

    /**
     *
     * @return
     */
    List<T> findAll();

    /**
     *
     * @param name
     * @return
     */
    T findByName (String name);
}
