package com.management.project.factory;

import com.management.project.dao.CompanyDAO;
import com.management.project.dao.hibernate.HibCompanyDao;
import com.management.project.models.Company;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * @author Slava Makhinich
 */
public final class HibFactoryDao {

    private static SessionFactory sessionFactory;
    private static CompanyDAO companyDAO;

    private HibFactoryDao() {
    }

    private static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            sessionFactory = new Configuration()
                    .configure("/META-INF/persistence.xml")
                    .addAnnotatedClass(Company.class)
                    .buildSessionFactory();
        }
        return sessionFactory;
    }

    public static CompanyDAO getCompanyDAO() {
        if (companyDAO == null) {
            companyDAO = new HibCompanyDao(getSessionFactory());
        }
        return companyDAO;
    }
}
