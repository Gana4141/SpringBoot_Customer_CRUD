package com.nit.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.nit.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

    public Optional<Student> findByEmail(String email);

    public List<Student> findByCourse(String course);

    public List<Student> findByFirstNameContaining(String name);

    @Query("SELECT s FROM Student s WHERE s.age >= :age")
    public List<Student> findStudentsOlderThan(@Param("age") int age);

    @Query(value = "SELECT * FROM students WHERE course = :course", nativeQuery = true)
    public List<Student> findByCourseNative(@Param("course") String course);

    public boolean existsByEmail(String email);
}