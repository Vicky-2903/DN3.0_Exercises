package task_Management_System;

public class Task {
    private int taskId;
    private String taskName;
    private String status;

    // Constructor
    public Task(int taskId, String taskName, String status) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.status = status;
    }

    // Getter for taskId
    public int getTaskId() {
        return taskId;
    }

    // Setter for taskId
    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    // Getter for taskName
    public String getTaskName() {
        return taskName;
    }

    // Setter for taskName
    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    // Getter for status
    public String getStatus() {
        return status;
    }

    // Setter for status
    public void setStatus(String status) {
        this.status = status;
    }

    // Method to display task details
    public void displayTaskDetails() {
        System.out.println("Task ID: " + taskId);
        System.out.println("Task Name: " + taskName);
        System.out.println("Status: " + status);
    }


}
