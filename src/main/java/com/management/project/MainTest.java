package com.management.project;

import com.management.project.dao.CompanyDAO;
import com.management.project.factory.HibFactoryDao;
import com.management.project.models.Company;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;


/**
 * @author Slava Makhinich
 *
 * The class for testing everything
 */
public class MainTest {
    static CompanyDAO companyDAO;

    public static void main(String[] args) {
        companyDAO = HibFactoryDao.getCompanyDAO();
        Company company = new Company(16, "changed");
        //System.out.println(companyDAO.save(company));
        //System.out.println(companyDAO.findById(16l));
        //companyDAO.update(company);
        //companyDAO.delete(new Company(16, "changed"));

//        List<Company> companies = companyDAO.findAll();
//        companies.forEach(System.out::println);

        System.out.println(companyDAO.findByName("hibComp"));




        HibFactoryDao.getSessionFactory().close();
    }
}
