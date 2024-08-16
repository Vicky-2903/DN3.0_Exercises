package com.employeemanagementsystem;

import com.employeemanagementsystem.model.Employee;
import com.employeemanagementsystem.model.Department;
import com.employeemanagementsystem.repository.EmployeeRepository;
import com.employeemanagementsystem.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class DataInitializers implements CommandLineRunner {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        Department hr = new Department();
        hr.setName("HR");
        departmentRepository.save(hr);

        Department it = new Department();
        it.setName("IT");
        departmentRepository.save(it);

        Employee emp1 = new Employee();
        emp1.setFirstName("Ryan");
        emp1.setLastName("Reynolds");
        emp1.setEmail("RyanReynolds@gmail.com");
        emp1.setDepartment(hr);
        employeeRepository.save(emp1);

        Employee emp2 = new Employee();
        emp2.setFirstName("Ryan");
        emp2.setLastName("Gosling");
        emp2.setEmail("RyanGosling@gmail.com");
        emp2.setDepartment(it);
        employeeRepository.save(emp2);

    }
}
