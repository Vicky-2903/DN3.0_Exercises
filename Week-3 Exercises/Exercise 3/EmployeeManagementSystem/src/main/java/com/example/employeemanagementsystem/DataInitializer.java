package com.example.employeemanagementsystem;

import com.example.employeemanagementsystem.model.Department;
import com.example.employeemanagementsystem.model.Employee;
import com.example.employeemanagementsystem.repository.DepartmentRepository;
import com.example.employeemanagementsystem.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.boot.CommandLineRunner;

@Component
public class DataInitializer implements CommandLineRunner {

    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;

    @Autowired
    public DataInitializer(EmployeeRepository employeeRepository, DepartmentRepository departmentRepository) {
        this.employeeRepository = employeeRepository;
        this.departmentRepository = departmentRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Department department1 = new Department("HR");
        Department department2 = new Department("IT");

        departmentRepository.save(department1);
        departmentRepository.save(department2);

        Employee employee1 = new Employee("John Doe", "john.doe@example.com", department1);
        Employee employee2 = new Employee("Jane Smith", "jane.smith@example.com", department2);

        employeeRepository.save(employee1);
        employeeRepository.save(employee2);
    }
}
