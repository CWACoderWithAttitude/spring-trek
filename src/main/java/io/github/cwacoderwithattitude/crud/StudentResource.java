package io.github.cwacoderwithattitude.crud;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class StudentResource {

   @Autowired
   private StudentRepository studentRepository;

   @GetMapping("/students")
   public List<Student> retrieveAllStudents() {
      return studentRepository.findAll();
   }

   @GetMapping("/students/{id}")
   public Student retrieveStudent(@PathVariable long id) {
      Optional<Student> student = studentRepository.findById(id);

      return student.get();
   }

   @PostMapping("/students")
   public ResponseEntity<Object> createStudent(@RequestBody Student student) {
      Student savedStudent = studentRepository.save(student);

      URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
            .buildAndExpand(savedStudent.getId()).toUri();

      return ResponseEntity.created(location).build();

   }

   @DeleteMapping("/students/{id}")
   public void deleteStudent(@PathVariable long id) {
      studentRepository.deleteById(id);
   }
}
