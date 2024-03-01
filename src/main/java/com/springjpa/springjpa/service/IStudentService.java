package com.springjpa.springjpa.service;

import com.springjpa.springjpa.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public interface IStudentService {

    Page<Student> getAll(Pageable pageable, Map<String, Object> filterMap);
}
