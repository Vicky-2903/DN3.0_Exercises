package task_Management_System;

public class TaskLinkedList {
	private TaskNode head;

    public TaskLinkedList() {
        this.head = null;
    }

    // Method to add a task to the linked list
    public void addTask(Task task) {
        TaskNode newNode = new TaskNode(task);
        if (head == null) {
            head = newNode;
        } else {
            TaskNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    // Method to search for a task by taskId
    public Task searchTask(int taskId) {
        TaskNode current = head;
        while (current != null) {
            if (current.task.getTaskId() == taskId) {
                return current.task;
            }
            current = current.next;
        }
        return null; // Task not found
    }

    // Method to traverse and display all tasks in the linked list
    public void traverseTasks() {
        TaskNode current = head;
        while (current != null) {
            current.task.displayTaskDetails();
            current = current.next;
        }
    }

    // Method to delete a task by taskId
    public boolean deleteTask(int taskId) {
        if (head == null) {
            return false; // List is empty
        }
        if (head.task.getTaskId() == taskId) {
            head = head.next;
            return true;
        }
        TaskNode current = head;
        while (current.next != null) {
            if (current.next.task.getTaskId() == taskId) {
                current.next = current.next.next;
                return true;
            }
            current = current.next;
        }
        return false; // Task not found
    }
}
