package com.management.project.factory;

import com.management.project.dao.CompanyDAO;
import com.management.project.dao.hibernate.HibCompanyDao;
import com.management.project.models.Company;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * The class implements the Factory pattern. It creates and supplies of Hibernate implementations of DAOs
 *
 * @author Slava Makhinich
 */
public final class HibFactoryDao {

    /**
     * An instance of SessionFactory
     */
    private static SessionFactory sessionFactory;
    /**
     * An instance of CompanyDAO
     */
    private static CompanyDAO companyDAO;

    /**
     * Private constructor
     */
    private HibFactoryDao() {
    }

    /**
     * The method returns an instance of SessionFactory, and creates it if it is not exist
     *
     * @return an instance of SessionFactory
     */
    public static SessionFactory getSessionFactory() {
        if ((sessionFactory == null) || (sessionFactory.isClosed())){
            sessionFactory = new Configuration()
                    .configure("/META-INF/persistence.xml")
                    .addAnnotatedClass(Company.class)
                    .buildSessionFactory();
        }
        return sessionFactory;
    }

    /**
     * The method returns an instance of CompanyDAO, and creates it if it is not exist
     *
     * @return an instance of CompanyDAO
     */
    public static CompanyDAO getCompanyDAO() {
        if (companyDAO == null) {
            companyDAO = new HibCompanyDao(getSessionFactory());
        }
        return companyDAO;
    }

    /**
     * The method closes an instance of SessionFactory if it's exist and open
     */
    public static void disconnect() {
        if ((sessionFactory != null) && (sessionFactory.isOpen()))
            sessionFactory.close();
    }
}
