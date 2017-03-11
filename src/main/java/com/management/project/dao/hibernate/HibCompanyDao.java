package com.management.project.dao.hibernate;

import com.management.project.dao.CompanyDAO;
import com.management.project.models.Company;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

/**
 * @author Slava Makhinich
 */
public class HibCompanyDao implements CompanyDAO {
    private SessionFactory sessionFactory;

    public HibCompanyDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Long save(Company company) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(company);
        transaction.commit();
        session.close();
        return null;
    }

    @Override
    public Company findById(Long aLong) {
        return null;
    }

    @Override
    public void update(Company obj) {

    }

    @Override
    public void delete(Company obj) {

    }

    @Override
    public List<Company> findAll() {
        return null;
    }

    @Override
    public Company findByName(String name) {
        return null;
    }
}
