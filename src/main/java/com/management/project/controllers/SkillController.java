package com.management.project.controllers;

import com.management.project.dao.GenericDAO;
import com.management.project.models.Skill;

import java.util.Scanner;

/**
 * @author Вадим
 */
public class SkillController extends AbstractModelController<Skill> {
    public SkillController(GenericDAO<Skill, Long> dao) {
        super(dao);
    }

    @Override
    protected Skill getNewModel() {
        System.out.print("Input skill name: ");
        String skillName = new Scanner(System.in).nextLine();
        Skill skill = new Skill(-100, skillName);
        return skill;
    }

    @Override
    protected void printMenu() {
        System.out.println();
        System.out.println("ACTIONS WITH SKILLS:");
        super.printMenu();
    }
}


