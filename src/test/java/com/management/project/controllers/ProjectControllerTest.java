package com.management.project.controllers;

import com.management.project.models.Project;
import org.junit.Test;

import java.util.Scanner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by Катя on 19.03.2017.
 */
public class ProjectControllerTest extends AbstractProjectControllerTest {
    private Project project;

    private AbstractModelController abstractModelController;
    @Test
    public void printMenu() {
        String menu = "ACTIONS WITH PROJECTS:";
        ProjectController projectController = null;
        projectController.printMenu();
        assertTrue(menu.contains(output.toString()));
    }


    @Test
    public void getNewModel(){
        String testName = new Scanner(System.in).nextLine();
        Project testProject = new Project();
        testProject.setName(testName);
        assertNotNull(testProject);
        assertEquals(testProject.getName(), testName);
    }




}
