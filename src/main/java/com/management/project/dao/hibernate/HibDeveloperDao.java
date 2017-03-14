package com.management.project.dao.hibernate;
import com.management.project.dao.DeveloperDAO;
import com.management.project.models.Developer;
import com.management.project.models.Skill;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import java.util.HashSet;
import java.util.List;

/**
 * The class implements a set of methods for working with database including Hibernate framework, with Developer entity
 * @author Вадим
 */
public class HibDeveloperDao implements DeveloperDAO {

    /**
     * An instance of SessionFactory
     */
    SessionFactory sessionFactory;

    /**
     * Constructor
     *
     * @param sessionFactory
     */
    public HibDeveloperDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    /**
     * The method saves a new developer in a database
     *
     * @param developer a developer, which must be save in a database
     * @return developer`s id if a developer was add to database successfully
     */
    @Override
    public Long save(Developer developer) {
        Long id = null;
        Transaction transaction = null;
        Session session = sessionFactory.openSession();
        try{
            transaction = session.beginTransaction();
            id = (Long) session.save(developer);
            transaction.commit();
        }catch (Exception e){
            if (transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException(e);
        } finally {
            session.close();
        }
        return id;
    }

    /**
     * The method finds a developer in database by id of developer
     *
     * @param id an id of a developer
     * @return a developer with entered id
     * or null if developer with this id does not exist in the database
     */
    @Override
    public Developer findById(Long id) {
        Developer developer;
        try (Session session = sessionFactory.openSession()){
            developer = session.get(Developer.class,id);
        }
        return developer;
    }

    /**
     * The method updates a developer in a database (finds developer in a database by id and overwrites other fields)
     *
     * @param developer  is a developer with new parameters
     */
    @Override
    public void update(Developer developer) {
        Developer developerNew;
        Transaction transaction = null;
        Session session = sessionFactory.openSession();
        try{
            transaction = session.beginTransaction();
            developerNew = session.get(Developer.class,developer.getId());
            developerNew.setName(developer.getName());
            developerNew.setSalary(developer.getSalary());
            developerNew.setCompany(developer.getCompany());
            developerNew.setProject(developer.getProject());
            developerNew.setSkills((HashSet<Skill>) developer.getSkills());
            session.clear();
            session.update(developerNew);
            transaction.commit();
        }catch (Exception e){
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }

    }

    /**
     * The method removes a developer from a database
     *
     * @param obj is a developer which must be removed
     */
    @Override
    public void delete(Developer obj) {
        Transaction transaction = null;
        Session session = sessionFactory.openSession();
        try{
            transaction = session.beginTransaction();
            Developer developer = session.get(Developer.class,obj.getId());
            developer.setCompany(null);
            developer.setProject(null);
            developer.setSkills(null);
            session.delete(developer);
            transaction.commit();
        }catch (Exception e){
            if (transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException(e);
        } finally {
            session.close();
        }

    }

    /**
     * The method returns all developers from a database
     *
     * @return list of all developers from a database
     */
    @Override
    public List<Developer> findAll() {
        List<Developer> developers;
        try(Session session = sessionFactory.openSession()){
            developers = session.createQuery("from Developer").list();
        }
        return developers;
    }

    /**
     * Method finds a developer in a database by name of the developer
     *
     * @param name is a name of a developer
     * @return a developer with entered name
     * or null if developer with this name does not exist in the database
     */
    @Override
    public Developer findByName(String name) {
        Developer developer;
        try (Session session = sessionFactory.openSession()){
            developer = (Developer) session.createQuery("from Developer d where d.name like :name")
                    .setParameter("name", name).uniqueResult();
        }
        return developer;
    }
}
