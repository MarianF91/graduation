package com.example.graduation.controller;

import com.example.graduation.model.NumerologyProfile;
import com.example.graduation.model.User;
import com.example.graduation.service.InputService;
import com.example.graduation.service.NumerologyService;
import com.example.graduation.utils.ResultPrinter;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NumerologyApp {
    public static void main(String[] args) {
        InputService inputService = new InputService();
        User user = inputService.getUserInput();

        if (!user.isValidDate()) {
            System.out.println("Invalid input detected. Please restart the app.");
            return;
        }

        NumerologyService numerologyService = new NumerologyService();
        NumerologyProfile profile = numerologyService.profileGenerator(user);

        ResultPrinter.printProfile(profile, user);
    }
}
