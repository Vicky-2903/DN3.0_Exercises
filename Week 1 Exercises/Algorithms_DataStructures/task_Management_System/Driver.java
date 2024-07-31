package task_Management_System;
import java.util.Scanner;
public class Driver {
    private static TaskLinkedList taskList = new TaskLinkedList();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            System.out.println("\nTask Management System");
            System.out.println("1. Add Task");
            System.out.println("2. Search Task");
            System.out.println("3. Traverse Tasks");
            System.out.println("4. Delete Task");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addTask();
                    break;
                case 2:
                    searchTask();
                    break;
                case 3:
                    traverseTasks();
                    break;
                case 4:
                    deleteTask();
                    break;
                case 5:
                    running = false;
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }

    private static void addTask() {
        System.out.print("Enter task ID: ");
        int taskId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.print("Enter task name: ");
        String taskName = scanner.nextLine();

        System.out.print("Enter task status: ");
        String status = scanner.nextLine();

        Task task = new Task(taskId, taskName, status);
        taskList.addTask(task);
        System.out.println("Task added successfully.");
    }

    private static void searchTask() {
        System.out.print("Enter task ID to search: ");
        int taskId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Task foundTask = taskList.searchTask(taskId);
        if (foundTask != null) {
            foundTask.displayTaskDetails();
        } else {
            System.out.println("Task not found.");
        }
    }

    private static void traverseTasks() {
        System.out.println("Traversing tasks:");
        taskList.traverseTasks();
    }

    private static void deleteTask() {
        System.out.print("Enter task ID to delete: ");
        int taskId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        boolean isDeleted = taskList.deleteTask(taskId);
        if (isDeleted) {
            System.out.println("Task deleted successfully.");
        } else {
            System.out.println("Task not found.");
        }
    }

}
