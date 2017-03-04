package com.management.project.dao.jdbc;

import com.management.project.connections.ConnectionDB;
import com.management.project.dao.SkillDAO;
import com.management.project.models.Skill;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Вадим
 */
public class JdbcSkillDAO implements SkillDAO {


    private final String SAVE = "INSERT INTO skills (SKILL) VALUES(?)";
    private final String FIND_BY_ID = "SELECT * FROM skills WHERE ID = ?";
    private final String UPDATE = "UPDATE skills SET SKILL = ? WHERE ID = ?";
    private final String DELETE = "DELETE FROM skills WHERE ID = ?";
    private final String FIND_ALL = "SELECT * FROM skills";
    private final String FIND_BY_NAME = "SELECT * FROM skills WHERE NAME = ? ";
    private final String GET_LAST_INSERTED = "SELECT LAST_INSERT_ID()";

    /**
     * a connection to database
     */
    private ConnectionDB connectionDB;

    /**
     * * Constructor.
     * @param connectionDB a connection to database
     */
    public JdbcSkillDAO(ConnectionDB connectionDB) {
        this.connectionDB = connectionDB;
    }

    /**
     * Method adds a new skill to database
     * @param obj a skill, which must to be store in the database
     * @return id of skill if skill was add to database successfully
     */
    @Override
    public Long save(Skill obj) {
        Long id;
        try(Connection connection = connectionDB.getConnection()){
            try (PreparedStatement preparedStatement = connection.prepareStatement(SAVE)) {
                preparedStatement.setString(1,obj.getName());
                preparedStatement.executeUpdate();
            }
            try (Statement statement = connection.createStatement()){
                ResultSet resultSet = statement.executeQuery(GET_LAST_INSERTED);
                resultSet.next();
                id = resultSet.getLong(1);
            }
            return id;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Method looking skill in database for id of skill
     * @param aLong id of skill
     * @return a skill with entered id
     *  or null if skill with this id does not exist
     */
    @Override
    public Skill findById(Long aLong) {
        try (Connection connection = connectionDB.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID)){
                preparedStatement.setLong(1,aLong);
                try (ResultSet resultSet = preparedStatement.executeQuery()){
                    if (!resultSet.next()){
                        return null;
                    }
                    return createSkill(resultSet);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Method updates name of skill
     * @param obj skill with new name
     */
    @Override
    public void update(Skill obj) {
        try (Connection connection = connectionDB.getConnection()){
            try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE)){
                preparedStatement.setString(1,obj.getName());
                preparedStatement.setLong(2,obj.getId());
                preparedStatement.executeUpdate();
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    /**
     * Method removes skill from database
     * @param obj skill which must be removed
     */
    @Override
    public void delete(Skill obj) {
        try (Connection connection = connectionDB.getConnection()){
            try (PreparedStatement preparedStatement = connection.prepareStatement(DELETE)){
                preparedStatement.setLong(1,obj.getId());
                preparedStatement.executeUpdate();
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Method returns all skills from database
     * @return list of all skills from database
     */
    @Override
    public List<Skill> findAll() {
        List <Skill> skillList = new ArrayList<>();
        try (Connection connection = connectionDB.getConnection()){
            try (Statement statement = connection.createStatement()){
                try (ResultSet resultSet = statement.executeQuery(FIND_ALL)){
                    while (resultSet.next()){
                        Skill skill = createSkill(resultSet);
                        skillList.add(skill);
                    }
                    return skillList;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Method looking skill in database for name of skill
     * @param name a name of skill
     * @return a skill with entered name
     *  or null if skill with this name does not exist
     */
    public Skill findByName(String name){
        try(Connection connection = connectionDB.getConnection()){
            try (PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_NAME)){
                preparedStatement.setString(1,name);
                try (ResultSet resultSet = preparedStatement.executeQuery()){
                    if (!resultSet.next()){
                        return null;
                    }
                    return createSkill(resultSet);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Method creates new skill
     * @param resultSet a set of result from statement query
     * @return a skill, which was created on the basis of resultSet
     * @throws SQLException
     */
    private Skill createSkill(ResultSet resultSet) throws SQLException {
        Skill skill = new Skill();
        skill.setId(resultSet.getLong("id"));
        skill.setName(resultSet.getString("skill"));
        return skill;
    }
}