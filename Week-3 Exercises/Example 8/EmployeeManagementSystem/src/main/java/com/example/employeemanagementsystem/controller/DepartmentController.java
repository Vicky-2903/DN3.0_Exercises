package com.example.employeemanagementsystem.controller;

import com.example.employeemanagementsystem.model.Department;
import com.example.employeemanagementsystem.projection.DepartmentDetails;
import com.example.employeemanagementsystem.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {

    @Autowired
    private DepartmentRepository departmentRepository;

    @GetMapping
    public ResponseEntity<List<Department>> getAllDepartments() {
        List<Department> departments = departmentRepository.findAll();
        return ResponseEntity.ok(departments);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Department> getDepartmentById(@PathVariable Long id) {
        Department department = departmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Department not found"));
        return ResponseEntity.ok(department);
    }

    @PostMapping
    public ResponseEntity<Department> createDepartment(@RequestBody Department department) {
        Department savedDepartment = departmentRepository.save(department);
        return ResponseEntity.ok(savedDepartment);
    }

    // Endpoint to get department by name using derived query method
    @GetMapping("/search/findByName")
    public ResponseEntity<Department> getDepartmentByName(@RequestParam String name) {
        Department department = departmentRepository.findByName(name);
        return department != null ? ResponseEntity.ok(department) : ResponseEntity.notFound().build();
    }

    // Endpoint to get department by name using named query
    @GetMapping("/search/findByNameNamedQuery")
    public ResponseEntity<Department> getDepartmentByNameNamedQuery(@RequestParam String name) {
        Department department = departmentRepository.findDepartmentByNameNamedQuery(name);
        return department != null ? ResponseEntity.ok(department) : ResponseEntity.notFound().build();
    }

    // Endpoint to get all departments using named query
    @GetMapping("/search/findAllNamedQuery")
    public ResponseEntity<List<Department>> getAllDepartmentsNamedQuery() {
        List<Department> departments = departmentRepository.findAllDepartmentsNamedQuery();
        return ResponseEntity.ok(departments);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Department> updateDepartment(
            @PathVariable Long id,
            @RequestBody Department departmentDetails) {
        // Check if the department exists
        Department department = departmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Department not found"));

        // Update fields
        department.setName(departmentDetails.getName());
        // Update other fields if necessary

        // Save the updated department
        Department updatedDepartment = departmentRepository.save(department);

        return ResponseEntity.ok(updatedDepartment);
    }
    
    @GetMapping("/details")
    public ResponseEntity<List<DepartmentDetails>> getAllDepartmentDetails() {
        List<DepartmentDetails> details = departmentRepository.findAllDepartmentDetails();
        return ResponseEntity.ok(details);
    }
}
