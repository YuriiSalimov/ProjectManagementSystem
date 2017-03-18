package com.management.project.models;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * The test class for Skills
 * @author Kate
 */
public class SkillTest {
    public  Skills skill = new Skills(106,"JAVA");
    @Test
    public void getId()  {
        assertTrue(skill.getID()==106);
    }

    @Test
    public void setId() throws Exception {
        skill.setID(107);
        assertTrue(skill.getID()==107);
    }

    @Test
    public void getName() throws Exception {
        assertTrue(skill.getSkillName().equals("JAVA"));
    }

    @Test
    public void setName() throws Exception {
        skill.setSkillName("JavaScript");
        assertTrue(skill.getSkillName().equals("JavaScript"));
    }

    @Test
    public void equals() throws Exception {
        Skills skill1 = new Skills(109,"C++");
        Skills skill2 = new Skills(109,"C++");
        assertEquals(skill1,skill2);
    }



}