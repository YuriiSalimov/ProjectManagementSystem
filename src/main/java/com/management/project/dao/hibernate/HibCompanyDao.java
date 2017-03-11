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
        Long id;
        Session session = sessionFactory.openSession();
        id = (Long)session.save(company);
        session.close();
        return id;
    }

    @Override
    public Company findById(Long id) {
        Company company;
        Session session = sessionFactory.openSession();
        company = session.get(Company.class, id);
        session.close();
        return company;
    }

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

    @Override
    public void delete(Company company) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Company companyFromDb = session.get(Company.class, company.getId());
        session.delete(companyFromDb);
        transaction.commit();
        session.close();
    }

    @Override
    public List<Company> findAll() {
        List<Company> companies;
        Session session = sessionFactory.openSession();
        companies = session.createQuery("from com.management.project.models.Company").list();
        session.close();
        return companies;
    }

    @Override
    public Company findByName(String name) {
        List<Company> companies = findAll();
        for (Company company: companies) {
            if (company.getName().equals(name)) {
                return company;
            }
        }
        return null;
    }
}
