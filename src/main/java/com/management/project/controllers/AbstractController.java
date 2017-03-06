package com.management.project.controllers;

import java.util.Scanner;

/**
 * Created by Slava on 06.03.2017.
 */
public abstract class AbstractController {

    public void start () {
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
        System.out.println("Input your choice:");
        try {
            choice = Integer.parseInt(new Scanner(System.in).nextLine());
        } catch (NumberFormatException e) {
            choice = -1;
        }
        return choice;
    }

    protected abstract void action(int choice);

    protected abstract void printMenu();

}
