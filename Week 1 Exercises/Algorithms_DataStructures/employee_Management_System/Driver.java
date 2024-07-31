package employee_Management_System;

import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter initial capacity for EmployeeOperations: ");
        int initialCapacity = scanner.nextInt();

        EmployeeOperations manager = new EmployeeOperations(initialCapacity);

        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Add Employee");
            System.out.println("2. Display All Employees");
            System.out.println("3. Search Employee by ID");
            System.out.println("4. Delete Employee by ID");
            System.out.println("5. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Employee ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();  // Consume newline

                    System.out.print("Enter Employee Name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter Employee Position: ");
                    String position = scanner.nextLine();

                    System.out.print("Enter Employee Salary: ");
                    double salary = scanner.nextDouble();

                    manager.addEmployee(new Employee(id, name, position, salary));
                    break;

                case 2:
                    System.out.println("All Employees:");
                    manager.displayEmployees();
                    break;

                case 3:
                    System.out.print("Enter Employee ID to search: ");
                    int searchId = scanner.nextInt();
                    Employee searchedEmployee = manager.searchEmployeeById(searchId);
                    System.out.println("\nSearched Employee:");
                    if (searchedEmployee != null) {
                        System.out.println(searchedEmployee);
                    } else {
                        System.out.println("Employee not found.");
                    }
                    break;

                case 4:
                    System.out.print("Enter Employee ID to delete: ");
                    int deleteId = scanner.nextInt();
                    boolean isDeleted = manager.deleteEmployeeById(deleteId);
                    System.out.println("\nDelete Status: " + (isDeleted ? "Employee deleted successfully." : "Employee not found."));
                    break;

                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
