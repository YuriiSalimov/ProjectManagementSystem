package dao;

import model.Developer;

/**
 * Created by Perevoznyk Pavel on 17.02.2017.
 * V 1.0a
 */
public interface DeveloperDAO extends GenericDAO<Developer, Long> {
    Developer findDeveloperByName(String firstName, String lastName);
}
