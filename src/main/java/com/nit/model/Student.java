package com.nit.model;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="student_managment")
public class Student
{
	@Id   
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	@Column(name="first_Name",nullable = false)
	@NotBlank(message = "first name is required ")
    private String firstName;
	@NotBlank(message = "last name is a required ")
	@Column(name="last_Name",nullable = false)
    private String lastName;
	@NotBlank(message = "Email is Required")
	@Email(message = "Enter valid email")
	@Column(name="email",unique = true,nullable = false)
    private String email;
	@Column(name="phones")
	@NotBlank(message = "phone is a required")
    private String phone;
	
	@Column(name ="course")
	@NotBlank(message = "course is required")
    private String course;
	@Min(value=1,message = "Age at least 1 ")
	@Max(value=100,message = "Age at least 1 ")
	@Column(name="Age")
    private Integer age;
	
	@Column(name="address")
    private String add;
	
	@CreationTimestamp
	@Column(name="created_at",updatable = false)	
    private LocalDateTime createdAt;
	@UpdateTimestamp
	@Column(name="updated_At")
    private LocalDateTime updatedAt;
    
}
