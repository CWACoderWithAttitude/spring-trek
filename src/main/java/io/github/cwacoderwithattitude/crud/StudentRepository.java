package io.github.cwacoderwithattitude.crud;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
   List<Student> findAll();

   List<Student> findByName(String name);

   Optional<Student> findById(long id);
}
