package com.management.project;

import com.management.project.dao.CompanyDAO;
import com.management.project.dao.DeveloperDAO;
import com.management.project.dao.ProjectDAO;
import com.management.project.dao.SkillDAO;
import com.management.project.factory.FactoryDao;
import com.management.project.factory.HibFactoryDao;
import com.management.project.models.*;

import java.sql.SQLException;
import java.util.HashSet;

/**
 * The class for testing everything
 *
 * @author Slava Makhinich
 */
public class MainTest {
    static CompanyDAO companyDAO;
    static DeveloperDAO developerDAO;
    static ProjectDAO projectDAO;
    static SkillDAO skillDAO;

    public static void main(String[] args) throws SQLException {
        companyDAO = HibFactoryDao.getCompanyDAO();
        developerDAO = HibFactoryDao.getDeveloperDAO();
        projectDAO = FactoryDao.getProjectDAO();
        skillDAO = HibFactoryDao.getSkillDAO();

        Company company = new Company(25, "changed");
        //System.out.println(companyDAO.save(company));
        //System.out.println(companyDAO.findById(16l));
        //companyDAO.update(company);
        //companyDAO.delete(new Company(16, "changed"));

        //        List<Company> companies = companyDAO.findAll();
        //        companies.forEach(System.out::println);

        company = companyDAO.findById(1L);
        Developer developer = new Developer("Test");
        developer.setCompany(company);
        Project project = projectDAO.findById(1L);
        developer.setProject(project);
        Developer developer1 = new Developer("Test2");
        Company company1 = new Company();
        company1.setName("TestCompany");
        developer1.setCompany(company1);
        Project project1 = new Project();
        project1.setName("TestProject");
        project1.setCompany(company);
        project1.setCustomer(new Customer(1, "f"));
        project1.setCost(100);
        developer1.setProject(project1);

        HashSet<Skill> skills = new HashSet<>();
        Skill skill1 = new Skill("TestSkill3");
        Skill skill2 = new Skill("TestSkill4");
        skills.add(skill1);
        skills.add(skill2);
        HashSet<Skill> skills1 = new HashSet<>();
        Skill skill3 = skillDAO.findById(1L);
        Skill skill4 = skillDAO.findById(10L);
        skills1.add(skill3);
        skills1.add(skill4);
        developer.setSkills(skills);
        developer1.setSkills(skills1);
        //        developerDAO.save(developer);
        //        developerDAO.save(developer1);
        //        System.out.println(developerDAO.findById(28L));
        //        developer1.setId(28L);
        //        developerDAO.delete(developerDAO.findById(26L));
        //        developer1.setName("Updated");
        //        developer1.setId(29L);
        //        developerDAO.update(developer1);

        //        System.out.println(developerDAO.findByName("Vdym"));
        //        developerDAO.findAll().forEach(System.out::println);

        HibFactoryDao.disconnect();

    }
}
