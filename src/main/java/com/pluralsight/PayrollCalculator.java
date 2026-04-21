package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class PayrollCalculator {
    public static void main(String[] args) {

        try {
            FileReader fileReader = new FileReader("employees.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String input; //store each line read from file

            while((input = bufferedReader.readLine()) != null) {
                String[] tokens = input.split("\\|"); //split the line stored inside input into the needed fields

                int employeeId = Integer.parseInt(tokens[0]);
                String name = tokens[1];
                double hoursWorked = Double.parseDouble(tokens[2]);
                double payRate = Double.parseDouble(tokens[3]);

                //create employee object with the split data we just got
                Employee employee = new Employee(employeeId, name, hoursWorked, payRate);

                System.out.printf("Employee ID: %d | Name: %s | Gross Pay: $%.2f%n",
                        employee.getEmployeeId(), employee.getName(), employee.getGrossPay());;
            }

        } catch (IOException e) {
            System.out.println("Error reading file.");
        }


    }
}
