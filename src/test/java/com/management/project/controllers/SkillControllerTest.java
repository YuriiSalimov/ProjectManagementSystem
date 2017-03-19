package com.management.project.controllers;

import com.management.project.models.Skill;
import org.junit.Test;

import java.util.Scanner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by Катя on 19.03.2017.
 */
public class SkillControllerTest extends AbstarctSkillControllerTest {
    private Skill skill;

    private AbstractModelController abstractModelController;
    @Test
    public void printMenu() {
        String menu = "ACTIONS WITH SKILLS:";
        SkillController skillController = null;
        skillController.printMenu();
        assertTrue(menu.contains(output.toString()));
    }


    @Test
    public void getNewModel(){
        String testName = new Scanner(System.in).nextLine();
        Skill testSkill = new Skill();
        testSkill.setName(testName);
        assertNotNull(testSkill);
        assertEquals(testSkill.getName(), testName);
    }


}
