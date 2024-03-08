package com.springjpa.springjpa.service;

import com.springjpa.springjpa.dao.StudentRepository;
import com.springjpa.springjpa.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;
import java.util.Objects;

@Service
@Transactional(readOnly = true)
public class StudentService implements IStudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Page<Student> getAll(Pageable pageable, Map<String, Object> filterMap) {
        String studentName = (String) filterMap.get("student_name");
        Integer studentAge = (Integer) filterMap.get("student_age");

        if (Objects.nonNull(studentName) && Objects.nonNull(studentAge)) {
            return studentRepository.findByNameAndAge(pageable, studentName, studentAge);
        }

        return studentRepository.findAll(pageable);
    }

    @Override
    public Integer getStudentsByHonor(String honor) {
        return studentRepository.findByHonor(honor);
    }

    @Override
    public Integer getCountByAge(Integer age) {
        return studentRepository.getTotalByAge(age);
    }
}
