package com.management.project.controllers;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * DESCRIPTION - ???
 *
 * @author Slava Makhinich
 */
public abstract class AbstractController {

    /**
     * @throws SQLException
     */
    public void start() throws SQLException {
        int choice;
        while (true) {
            printMenu();
            choice = readChoice();
            if (choice == 0) {
                break;
            }
            action(choice);
        }
    }

    /**
     * @return
     */
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

    /**
     * @param choice
     * @throws SQLException
     */
    protected abstract void action(int choice) throws SQLException;

    /**
     *
     */
    protected abstract void printMenu();
}
