package com.nit.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nit.model.Student;
import com.nit.service.StudentService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/students")
@RequiredArgsConstructor
public class StudentController
{
     private final StudentService studentService;         
     @PostMapping
     public ResponseEntity<Student> createStudent(@Valid @RequestBody Student student)
     {
    	 
    	 Student saved =studentService.createStudent(student);
    	 return  ResponseEntity.status(HttpStatus.CREATED).body(saved);
     }
     @GetMapping("/{id}")
     public ResponseEntity<Student> getStudentById(@PathVariable Long id)
     {
    	 return ResponseEntity.ok(studentService.getStudentById(id));
     }
     
     @GetMapping("/email/{email}")
     public ResponseEntity<Student> getStudentByEmail(@PathVariable String email)
     {
    	 
    	 return ResponseEntity.ok(studentService.getStudentByEmail(email));
     }
     
		/*
		 * public ResponseEntity<List<Student>> searchStudent(@RequestParam String name)
		 * { ResponseEntity.ok(studentService.searchByName(name)); }
		 */
     
     @GetMapping("/count")
     public ResponseEntity<Long> countsStudent()
     {
    	 return ResponseEntity.ok(studentService.countStudents());
     }
     @DeleteMapping("/{id}")
     public ResponseEntity<String> deleteStudent(
             @PathVariable Long id) {
         studentService.deleteStudent(id);
         return ResponseEntity.ok(
             "Student deleted successfully with ID: " + id
         );
     }

		/*
		 * // ── DELETE ALL — DELETE ───────────────────────────────
		 * 
		 * @DeleteMapping public ResponseEntity<String> deleteAllStudents() {
		 * studentService.deleteStudent(); return
		 * ResponseEntity.ok("All students deleted successfully"); }
		 */
}
