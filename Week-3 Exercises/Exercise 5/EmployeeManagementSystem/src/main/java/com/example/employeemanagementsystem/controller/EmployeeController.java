package com.example.employeemanagementsystem.controller;

import com.example.employeemanagementsystem.model.Employee;
import com.example.employeemanagementsystem.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
        return employeeRepository.findById(id)
                .map(employee -> ResponseEntity.ok().body(employee))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
        if (!employeeRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        employee.setId(id);
        return ResponseEntity.ok().body(employeeRepository.save(employee));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
        if (!employeeRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        employeeRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

 // Find employees by name
    @GetMapping("/search/findByName")
    public List<Employee> getEmployeesByName(@RequestParam String name) {
        return employeeRepository.findByName(name);
    }


    // Find employees by department name using the custom JPQL query
    @GetMapping("/search/findEmployeesByDepartmentName")
    public List<Employee> getEmployeesByDepartmentName(@RequestParam String departmentName) {
        return employeeRepository.findEmployeesByDepartmentName(departmentName);
    }

    // Find employees by department name using the named query
    @GetMapping("/search/findEmployeesByDepartmentNameNamedQuery")
    public List<Employee> getEmployeesByDepartmentNameNamedQuery(@RequestParam String departmentName) {
        return employeeRepository.findEmployeesByDepartmentNameNamedQuery(departmentName);
    }

}
