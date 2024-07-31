package employee_Management_System;

public class Employee {
	private int employeeId;
	private String name;
	private String position;
	private double salary;

	// Constructor
	public Employee(int employeeId, String name, String position, double salary) {
		this.employeeId = employeeId;
		this.name = name;
		this.position = position;
		this.salary = salary;
	}

	// Getters
	public int getEmployeeId() {
		return employeeId;
	}

	public String getName() {
		return name;
	}

	public String getPosition() {
		return position;
	}

	public double getSalary() {
		return salary;
	}

	// Setters
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	// toString method to display the employee details
	@Override
	public String toString() {
		return "Employee{" + "employeeId=" + employeeId + ", name='" + name + '\'' + ", position='" + position + '\''
				+ ", salary=" + salary + '}';
	}

}
