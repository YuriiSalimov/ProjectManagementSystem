package com.management.project.models;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashSet;

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
        developer.setSalary(-123);
        assertEquals(developer.getSalary(), 0);
    }

    @Test
    public void getSkills() throws Exception {
        HashSet<Skill> skills = new HashSet<>();
        developer = new Developer(1l, "Den", null, null, 1, skills);
        assertTrue(skills == developer.getSkills());

    }

    @Test
    public void setSkills() throws Exception {
        developer = new Developer();
        HashSet<Skill> skills = new HashSet<>();
        skills.add(new Skill(1,"wqaef"));
        developer.setSkills(skills);
        assertTrue(developer.getSkills().equals(skills));
    }

    @Test
    public void setSkillsNull() throws Exception {
        developer = new Developer();
        HashSet<Skill> skills = null;
        developer.setSkills(skills);
        assertNotNull(developer.getSkills());
    }

    @Test
    public void addSkill() throws Exception {
        HashSet<Skill> skills = new HashSet<>();
        developer = new Developer(1l, "Den", null, null, 1, skills);
        Skill skill = new Skill(1,"Java");
        assertTrue(developer.addSkill(skill));
        assertFalse(developer.addSkill(skill));
        assertTrue(developer.getSkills().contains(skill));

        assertFalse(developer.addSkill(null));
    }

    @Test
    public void removeSkill() throws Exception {
        Skill skill = new Skill(1,"Java");
        HashSet<Skill> skills = new HashSet<>();
        skills.add(skill);
        developer = new Developer(1, "SomeName", null, null, 333, skills);
        assertTrue(developer.removeSkill(skill));
        assertFalse(developer.getSkills().contains(skill));
        assertFalse(developer.removeSkill(skill));

        Skill skillNull = null;
        assertFalse(developer.removeSkill(skillNull));
    }

    @Test
    public void equals() throws Exception {
        company = new Company(1, "BMW");
        project = new Project(7000, "NewGame", 3000, null, null);
        developer = new Developer(100, "Pavel", company, project, 2000);
        assertTrue(developer.equals(developer));

        Developer developer1 = new Developer(100, "Pavel", company, project, 2000);
        assertTrue(developer1.equals(developer));

        developer1.setName("Petr");
        assertFalse(developer1.equals(developer));

        developer1.setName("Pavel");
        assertEquals(developer1,developer);

        developer.setCompany(null);
        assertNotEquals(developer1, developer);

        developer1.setCompany(null);
        assertEquals(developer1, developer);

        assertFalse(developer.equals(null));
    }

    @Test
    public void testHashCode() throws Exception {
        company = new Company(1, "BMW");
        project = new Project(7000, "NewGame", 3000, null, null);
        developer = new Developer(100, "Pavel", company, project, 2000);
        Developer developer1 = new Developer(100, "Pavel", company, project, 2000);
        assertTrue(developer1.hashCode() == developer.hashCode());
        developer.setId(50);
        assertFalse(developer.hashCode() == developer1.hashCode());

        developer.setId(100);
        developer1.setCompany(null);
        assertFalse(developer1.hashCode() == developer.hashCode());
    }

    @Test
    public void testToString() throws Exception {
        developer = new Developer(12345, "Dima", 5000);
        assertTrue(developer.toString().contains("Dima"));
        assertTrue(developer.toString().contains("12345"));
        assertTrue(developer.toString().contains("5000"));
    }
}