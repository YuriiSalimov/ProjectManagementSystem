package com.management.project.dao;

import com.management.project.models.Developer;

/**
 * Created by Perevoznyk Pavel on 17.02.2017.
 * V 1.0a
 */
public interface DeveloperDAO extends GenericDAO<Developer, Long> {

    Developer findDeveloperByName(String name);
}
