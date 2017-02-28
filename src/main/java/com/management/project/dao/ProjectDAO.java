package dao;

import model.Project;

/**
 * Created by Perevoznyk Pavel on 20.02.2017.
 * V 1.0a
 */
public interface ProjectDAO extends GenericDAO<Project, Long> {
    Project findByName(String name);
}