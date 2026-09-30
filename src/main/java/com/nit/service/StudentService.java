package com.nit.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nit.model.Student;

@Service
public interface StudentService
{
     public Student createStudent(Student student);
     public List<Student> getAllStudents();
     public Student getStudentById(Long id);
     public Student getStudentByEmail(String email);
     public List<Student> getStudentbyCourse(String course);
     public Student updateStudent(Long id,Student stuent);
     public void deleteStudent(Long id);
     public List<Student> searchByName(String name);
     public long countStudents();
}
