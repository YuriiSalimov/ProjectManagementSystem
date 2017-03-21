package com.management.project.controllers;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author Slava Makhinich
 */
public abstract class AbstractController {

    public void start () throws SQLException {
        int choice;
        while (true){
            printMenu();
            choice = readChoice();
            if (choice == 0) {
                break;
            }
            action(choice);
        }
    }

    protected int readChoice() {
        int choice;
        System.out.println("Input your choice: ");
        try {
            choice = new Scanner(System.in).nextInt();
        } catch (InputMismatchException e) {
            choice = -1;
        }
        return choice;
    }

    protected abstract void action(int choice) throws SQLException;

    protected abstract void printMenu();

}
