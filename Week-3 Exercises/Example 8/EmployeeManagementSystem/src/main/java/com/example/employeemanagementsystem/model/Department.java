package com.example.employeemanagementsystem.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.EntityListeners;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "departments")
@Getter
@Setter
@NoArgsConstructor
@NamedQueries({ @NamedQuery(name = "Department.findByName", query = "SELECT d FROM Department d WHERE d.name = :name"),
		@NamedQuery(name = "Department.findAll", query = "SELECT d FROM Department d") })
@EntityListeners(AuditingEntityListener.class)
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	@CreatedBy
	private String createdBy;

	@LastModifiedBy
	private String lastModifiedBy;

	@CreatedDate
	@Temporal(TemporalType.TIMESTAMP)
	private LocalDateTime createdDate;

	@LastModifiedDate
	@Temporal(TemporalType.TIMESTAMP)
	private LocalDateTime lastModifiedDate;

	// Parameterized constructor (if needed)
	public Department(String name) {
		this.name = name;
	}

	// Getters and setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
