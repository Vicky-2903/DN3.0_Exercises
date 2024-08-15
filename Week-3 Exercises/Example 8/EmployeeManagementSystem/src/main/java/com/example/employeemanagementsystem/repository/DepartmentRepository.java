package com.example.employeemanagementsystem.repository;

import com.example.employeemanagementsystem.model.Department;
import com.example.employeemanagementsystem.projection.DepartmentDetails;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

    // Derived query method to find a department by name
    Department findByName(String name);

    // Named query method to find a department by name
    @Query(name = "Department.findByName")
    Department findDepartmentByNameNamedQuery(@Param("name") String name);

    // Named query method to get all departments
    @Query(name = "Department.findAll")
    List<Department> findAllDepartmentsNamedQuery();
    
    @Query("SELECT new com.example.employeemanagementsystem.projection.DepartmentDetails(d.id, d.name) FROM Department d")
    List<DepartmentDetails> findAllDepartmentDetails();
}
