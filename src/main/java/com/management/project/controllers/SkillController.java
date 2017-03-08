package com.management.project.controllers;

import com.management.project.dao.GenericDAO;
import com.management.project.models.Skill;

/**
 * just a frame, need to fill
 */
public class SkillController extends AbstractModelController<Skill> {
    public SkillController(GenericDAO<Skill, Long> dao) {
        super(dao);
    }

    @Override
    protected Skill getNewModel() {
        return null;
    }
}
