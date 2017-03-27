package com.management.project.controllers;

import com.management.project.dao.GenericDAO;
import com.management.project.models.Model;

import java.util.Scanner;

/**
 * DESCRIPTION - ???
 *
 * @author Slava Makhinich
 */
public abstract class AbstractModelController<T extends Model> extends AbstractController {

    /**
     *
     */
    protected final GenericDAO<T, Long> dao;

    /**
     * @param dao
     */
    public AbstractModelController(GenericDAO<T, Long> dao) {
        this.dao = dao;
    }

    @Override
    protected void printMenu() {
        System.out.println("1 - add new");
        System.out.println("2 - update");
        System.out.println("3 - find by id");
        System.out.println("4 - find by name");
        System.out.println("5 - delete");
        System.out.println("6 - show all");
        System.out.println("0 - go to main menu");
    }

    @Override
    protected void action(int choice) {
        switch (choice) {
        case 1:
            addNew();
            break;
        case 2:
            update();
            break;
        case 3:
            findByIdAndOutput();
            break;
        case 4:
            findByNameAndOutput();
            break;
        case 5:
            deleteById();
            break;
        case 6:
            showAll();
            break;
        }
    }

    protected void showAll() {
        dao.findAll().forEach(System.out::println);
    }

    protected void deleteById() {
        System.out.print("Delete by id. Input id: ");
        long id = new Scanner(System.in).nextLong();
        T model = dao.findById(id);
        if (model == null) {
            System.out.println("Model with this id is not found");
            return;
        }
        System.out.println("Delete: " + model);
        dao.delete(model);
    }

    protected void addNew() {
        T model = getNewModel();
        System.out.println("Id of new model: " + dao.save(model));
    }

    protected void update() {
        System.out.print("Update. Input id: ");
        long id = new Scanner(System.in).nextLong();
        T oldModel = dao.findById(id);
        if (oldModel == null) {
            System.out.println("Model with this id is not found");
            return;
        }
        System.out.println("Input new information for " + oldModel);
        T model = getNewModel();
        model.setId(id);
        System.out.println("New data: ");
        System.out.println(model);
        dao.update(model);
    }

    protected void findByIdAndOutput() {
        System.out.print("Find by id. Input id: ");
        long id = new Scanner(System.in).nextLong();
        T model = dao.findById(id);
        System.out.println(model);
    }

    protected void findByNameAndOutput() {
        System.out.print("Find by name. Input name: ");
        String name = new Scanner(System.in).nextLine();
        T model = dao.findByName(name);
        System.out.println(model);
    }

    protected abstract T getNewModel();
}
