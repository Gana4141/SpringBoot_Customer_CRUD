package com.nit.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nit.model.Student;
import com.nit.repository.StudentRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StudentServiceimple implements StudentService {

    private final StudentRepository studentRepository;

    @Override
    public Student createStudent(Student student) {

        if (studentRepository.existsByEmail(student.getEmail())) {
            throw new RuntimeException(
                "Email Already Exists " + student.getEmail()
            );
        }

        return studentRepository.save(student);
    }

    @Override
    public List<Student> getAllStudents() {

        System.out.println("All Student record");

        return studentRepository.findAll();
    }

    @Override
    public Student getStudentById(Long id) {

        return studentRepository.findById(id)
                .orElseThrow(() ->
                    new RuntimeException(
                        "Student not found with id " + id
                    )
                );
    }

    @Override
    public Student getStudentByEmail(String email) {

        return studentRepository.findByEmail(email)
                .orElseThrow(() ->
                    new RuntimeException(
                        "Student not found with email " + email
                    )
                );
    }

    @Override
    public List<Student> getStudentbyCourse(String course) {

        return studentRepository.findByCourse(course);
    }

    @Override
    public Student updateStudent(Long id, Student updatedStudent) {

        Student existing = getStudentById(id);

        existing.setFirstName(updatedStudent.getFirstName());
        existing.setLastName(updatedStudent.getLastName());
        existing.setEmail(updatedStudent.getEmail());
        existing.setPhone(updatedStudent.getPhone());
        existing.setCourse(updatedStudent.getCourse());
        existing.setAge(updatedStudent.getAge());
        existing.setAdd(updatedStudent.getAdd());

        return studentRepository.save(existing);
    }

    @Override
    public void deleteStudent(Long id) {

        Student student = getStudentById(id);

        studentRepository.delete(student);
    }

    @Override
    public List<Student> searchByName(String name) {

        return studentRepository.findByFirstNameContaining(name);
    }

    @Override
    public long countStudents() {

        return studentRepository.count();
    }
}