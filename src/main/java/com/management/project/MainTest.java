package com.management.project;

import com.management.project.dao.CompanyDAO;
import com.management.project.factory.HibFactoryDao;
import com.management.project.models.Company;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


/**
 * @author Slava Makhinich
 *
 * The class for testing everything
 */
public class MainTest {
    static CompanyDAO companyDAO;

    public static void main(String[] args) {
        companyDAO = HibFactoryDao.getCompanyDAO();
        Company company = new Company(-1, "absolutelyNewCompany");
        //System.out.println(companyDAO.save(company));


    }
}
