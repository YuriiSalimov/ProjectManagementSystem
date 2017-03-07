package com.management.project.controllers;

import com.management.project.dao.GenericDAO;
import com.management.project.models.Model;

import java.io.Serializable;
import java.util.Scanner;

/**
 * Created by Slava on 07.03.2017.
 */
public abstract class AbstractModelController<T extends Model> extends AbstractController {

    protected final GenericDAO<T, Long> dao;

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

    private void showAll() {
        dao.findAll().forEach(System.out::println);
    }

    private void deleteById() {
        System.out.print("Delete by id. Input id: ");
        long id = new Scanner(System.in).nextLong();
        T model = dao.findById(id);
        dao.delete(model);
    }

    protected void addNew() {
        T model = getNewModel();
        System.out.println("Id of new model: " + dao.save(model));
    }

    private void update() {
        System.out.print("Update. Input id: ");
        long id = new Scanner(System.in).nextLong();
        System.out.println("Input new information for " + dao.findById(id));
        T model = getNewModel();
        model.setId(id);
        dao.update(model);
    }

    protected void findByIdAndOutput() {
        System.out.print("Find by id. Input id: ");
        long id = new Scanner(System.in).nextLong();
        T model = dao.findById(id);
        System.out.println(model);
        System.out.println();
    }

    protected void findByNameAndOutput() {
        System.out.print("Find by name. Input name: ");
        String name = new Scanner(System.in).nextLine();
        T model = dao.findByName(name);
        System.out.println(model);
    }

    protected abstract T getNewModel();
}
