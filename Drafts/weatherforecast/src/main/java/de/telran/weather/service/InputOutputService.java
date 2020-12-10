package de.telran.weather.service;

import java.util.Scanner;

public class InputOutputService {

    private Scanner scanner;

    public String readValue() {
        System.out.println("Enter city: ");
        scanner = new Scanner(System.in);
        String city = scanner.nextLine();
        return city;
    }

    public void print(String value) {
        System.out.println(value);
    }
}
