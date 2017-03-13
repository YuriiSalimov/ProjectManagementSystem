package com.management.project.dao.hibernate;

import com.management.project.dao.CompanyDAO;
import com.management.project.models.Company;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.management.Query;
import java.util.List;

/**
 * The class implements a set of methods for working with database including Hibernate framework, with Company entity
 *
 * @author Slava Makhinich
 */
public class HibCompanyDao implements CompanyDAO {

    /**
     * An instance of SessionFactory
     */
    private SessionFactory sessionFactory;

    /**
     * Constructor
     *
     * @param sessionFactory
     */
    public HibCompanyDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    /**
     * The method saves a new project in a database
     *
     * @param company a company, which must be save in a database
     * @return companies id if a company was add to database successfully
     */
    @Override
    public Long save(Company company) {
        Long id;
        Session session = sessionFactory.openSession();
        id = (Long)session.save(company);
        session.close();
        return id;
    }

    /**
     * The method finds a company in database by id of company
     *
     * @param id an id of a company
     * @return a company with entered id
     * or null if company with this id does not exist in the database
     */
    @Override
    public Company findById(Long id) {
        Company company;
        Session session = sessionFactory.openSession();
        company = session.get(Company.class, id);
        session.close();
        return company;
    }

    /**
     * The method updates a company in a database (finds company in a database by id and overwrites other fields)
     *
     * @param company  is a company with new parameters
     */
    @Override
    public void update(Company company) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Company companyFromDb = session.get(Company.class, company.getId());
        companyFromDb.setName(company.getName());
        session.update(companyFromDb);
        transaction.commit();
        session.close();
    }

    /**
     * The method removes a company from a database
     *
     * @param company is a company which must be removed
     */
    @Override
    public void delete(Company company) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Company companyFromDb = session.get(Company.class, company.getId());
        session.delete(companyFromDb);
        transaction.commit();
        session.close();
    }

    /**
     * The method returns all companies from a database
     *
     * @return list of all companies from a database
     */
    @Override
    public List<Company> findAll() {
        List<Company> companies;
        Session session = sessionFactory.openSession();
        companies = session.createQuery("from Company").list();
        session.close();
        return companies;
    }

    /**
     * Method finds a company in a database by name of the company
     *
     * @param name is a name of a company
     * @return a company with entered name
     * or null if company with this name does not exist in the database
     */
    @Override
    public Company findByName(String name) {
        Session session = sessionFactory.openSession();
        List<Company> companies = session.createQuery("select c from Company c where c.name like :name")
                .setParameter("name", name).list();
        session.close();
        if (companies.size() != 0) {
            return companies.get(0);
        }
        return null;
    }
}
