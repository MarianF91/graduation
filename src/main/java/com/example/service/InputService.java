package com.example.graduation.service;

import com.example.graduation.model.User;

import java.util.Scanner;

public class InputService {
    public User getUserInput() {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter your first name: ");
        String firstName = scan.nextLine();

        System.out.print("Enter your last name: ");
        String lastName = scan.nextLine();

        System.out.print("Enter your birth year (4 digits): ");
        int year = scan.nextInt();

        System.out.print("Enter your birth month (1-12): ");
        int month = scan.nextInt();

        System.out.print("Enter your birth day (1-31): ");
        int day = scan.nextInt();

        scan.close();
        return new User(firstName, lastName, year, month, day);
    }
}
