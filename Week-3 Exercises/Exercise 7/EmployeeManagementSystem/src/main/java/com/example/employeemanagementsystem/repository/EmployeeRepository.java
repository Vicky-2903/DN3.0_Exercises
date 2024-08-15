package com.example.employeemanagementsystem.repository;

import com.example.employeemanagementsystem.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    // Custom query method using keyword 'findBy' - Finds employees by their name
    List<Employee> findByName(String name);

    // Custom query method using keyword 'findBy' with department's name - Finds employees by department's name
    List<Employee> findByDepartment_Name(String departmentName);

    // Custom query using @Query - Finds employees by department's name using JPQL
    @Query("SELECT e FROM Employee e WHERE e.department.name = :departmentName")
    List<Employee> findEmployeesByDepartmentName(@Param("departmentName") String departmentName);

    // Named query usage - Define the named query in the Employee entity class
    @Query(name = "Employee.findByDepartment")
    List<Employee> findEmployeesByDepartmentNameNamedQuery(@Param("departmentName") String departmentName);

    // Method to get employees with pagination and sorting
    Page<Employee> findByDepartment_Name(String departmentName, Pageable pageable);
}
