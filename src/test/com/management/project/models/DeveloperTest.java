package com.management.project.models;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Slava on 03.03.2017.
 */
public class DeveloperTest {
    private Developer developer;
    private Company company;
    private Project project;

    @Test
    public void getId() throws Exception {
        developer = new Developer(123l, "Nata", 60000);
        assertEquals(123l, developer.getId());
    }

    @Test
    public void setId() throws Exception {
        developer = new Developer(123l, "Nata", 60000);
        developer.setId(555);
        assertTrue(developer.getId() == 555);
    }

    @Test
    public void getName() throws Exception {
        developer = new Developer("developer");
        assertEquals("developer", developer.getName());
    }

    @Test
    public void setName() throws Exception {
        developer = new Developer("developer");
        developer.setName("new developer");
        assertEquals("new developer", developer.getName());
        developer.setName(null);
        assertEquals("", developer.getName());

    }

    @Test
    public void getCompany() throws Exception {
        company = new Company(10001, "Apple");
        developer = new Developer(123, "Slava", company, null, 3000);
        assertTrue(company == developer.getCompany());

    }

    @Test
    public void setCompany() throws Exception {
        company = new Company(10001, "Apple");
        developer = new Developer(123, "Slava", null, null, 3000);
        developer.setCompany(company);
        assertTrue(developer.getCompany() == company);
    }

    @Test
    public void getProject() throws Exception {
        project = new Project(7000, "NewGame", 3000, null, null);
        developer = new Developer(1000, "Vova", null, project, 10000);
        assertTrue(developer.getProject() == project);
    }

    @Test
    public void setProject() throws Exception {
        project = new Project(7000, "NewGame", 3000, null, null);
        developer = new Developer(1200, "Igor", null, null, 3000);
        developer.setProject(project);
        assertTrue(developer.getProject() == project);
    }

    @Test
    public void getSalary() throws Exception {
        developer = new Developer(5000, "Joe", 859);
        assertEquals(859, developer.getSalary());
    }

    @Test
    public void setSalary() throws Exception {
        developer = new Developer("Joe");
        developer.setSalary(6001);
        assertEquals(6001, developer.getSalary());
    }

    @Test
    public void getSkills() throws Exception {

    }

    @Test
    public void setSkills() throws Exception {

    }

    @Test
    public void addSkill() throws Exception {

    }

    @Test
    public void removeSkill() throws Exception {

    }

    @Test
    public void equals() throws Exception {

    }

    @Test
    public void testHashCode() throws Exception {

    }

    @Test
    public void testToString() throws Exception {

    }

}