package com.example.employeemanagementsystem.projection;

import lombok.Data;

@Data
public class DepartmentDetails {
    private Long id;
    private String name;

    public DepartmentDetails(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
