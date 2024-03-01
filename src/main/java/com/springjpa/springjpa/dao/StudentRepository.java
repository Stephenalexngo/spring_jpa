package com.springjpa.springjpa.dao;

import com.springjpa.springjpa.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface StudentRepository extends JpaRepository<Student, UUID> {

    @Query(value = "SELECT s FROM Student s WHERE s.name = :name AND s.age = :age")
    Page<Student> findByNameAndAge(Pageable pageable, String name, Integer age);
}
