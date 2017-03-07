package com.management.project.controllers;

import com.management.project.dao.CompanyDAO;
import com.management.project.dao.GenericDAO;
import com.management.project.dao.ProjectDAO;
import com.management.project.dao.SkillDAO;
import com.management.project.factory.FactoryDao;
import com.management.project.models.Company;
import com.management.project.models.Developer;
import com.management.project.models.Project;
import com.management.project.models.Skill;

import java.sql.SQLException;
import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by Slava on 07.03.2017.
 */
public class DeveloperController extends AbstractModelController<Developer> {

    protected SkillDAO skillDAO = FactoryDao.getSkillDAO();
    protected CompanyDAO companyDAO = FactoryDao.getCompanyDAO();
    protected ProjectDAO projectDAO = FactoryDao.getProjectDAO();

    public DeveloperController(GenericDAO<Developer, Long> dao) throws SQLException {
        super(dao);
    }

    @Override
    protected void printMenu() {
        System.out.println();
        System.out.println("Actions with developer:");
        super.printMenu();
    }

    @Override
    protected Developer getNewModel() {
        System.out.print("Input developer name: ");
        String developerName = new Scanner(System.in).nextLine();
        System.out.println("Input developer salary: ");
        int salary = new Scanner(System.in).nextInt();
        System.out.println("Input company id: ");
        long companyId = new Scanner(System.in).nextLong();
        System.out.println("Input project id: ");
        long projectId = new Scanner(System.in).nextLong();
        System.out.print("Input skill ids (example: 1,2,3... ): ");
        String skillIdLine = new Scanner(System.in).nextLine().replaceAll(" ","");
        HashSet<Skill> skillsSet = new HashSet<>();
        for (String skillId: skillIdLine.split(",")){
            Skill skill = skillDAO.findById(Long.parseLong(skillId));
            if (skill != null) {
                skillsSet.add(skill);
            }
        }
        Company company = new Company(companyId, "bla-bla"); //companyDAO.findById(companyId);   -- эаменить когда допшут JdbcCompanyDAO
        Project project = projectDAO.findById(projectId);
        Developer developer = new Developer(-100, developerName, company, project, salary, skillsSet);
        return developer;
    }
}
