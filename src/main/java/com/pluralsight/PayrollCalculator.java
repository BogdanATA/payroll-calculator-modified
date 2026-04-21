package com.pluralsight;

import java.io.*;
import java.util.Scanner;

public class PayrollCalculator {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        //get user info
        System.out.println("Enter the name of the employee file to process: ");
        String inputFile = scanner.nextLine();

        System.out.println("Enter the name of the payroll file to create: ");
        String outputFile = scanner.nextLine();

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(outputFile));

            String input; //store each line read from file

            while((input = bufferedReader.readLine()) != null) {
                String[] tokens = input.split("\\|"); //split the line stored inside input into the needed fields

                int employeeId = Integer.parseInt(tokens[0]);
                String name = tokens[1];
                double hoursWorked = Double.parseDouble(tokens[2]);
                double payRate = Double.parseDouble(tokens[3]);

                //create employee object with the split data we just got
                Employee employee = new Employee(employeeId, name, hoursWorked, payRate);

                //write employee data into the output file
                bufferedWriter.write(employee.getEmployeeId() + " |" + employee.getName() + " |" + String.format("%.2f", employee.getGrossPay()));
                /*System.out.printf("Employee ID: %d | Name: %s | Gross Pay: $%.2f%n",
                        employee.getEmployeeId(), employee.getName(), employee.getGrossPay());*/
            }
            bufferedReader.close();
        } catch (IOException e) {
            System.out.println("Error reading file.");
        }


    }
}
