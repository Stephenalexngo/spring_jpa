package com.springjpa.springjpa.service;

import com.springjpa.springjpa.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Map;

public interface IStudentService {

    Page<Student> getAll(Pageable pageable, Map<String, Object> filterMap);

    Integer getStudentsByHonor(String honor);

    Integer getCountByAge(Integer age);
}
