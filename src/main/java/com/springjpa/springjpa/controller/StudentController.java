package com.springjpa.springjpa.controller;

import com.springjpa.springjpa.dto.StudentJsonDTO;
import com.springjpa.springjpa.model.Student;
import com.springjpa.springjpa.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/students")
public class StudentController {

    private static final String NAME_PARAM = "student_name";
    private static final String AGE_PARAM = "student_age";
    private static final String HONOR_PARAM = "student_honor";

    @Autowired
    private IStudentService studentService;

    private List<StudentJsonDTO> convertAccountsToDTO(Page<Student> students) {
        return students.stream()
                .map(StudentJsonDTO::new)
                .collect(Collectors.toList());
    }

    @GetMapping
    public List<StudentJsonDTO> getStudents(
            @PageableDefault(sort = "name", direction = Sort.Direction.DESC) Pageable pageable,
            @RequestParam(value = NAME_PARAM, required = false) String name,
            @RequestParam(value = AGE_PARAM, required = false) Integer age) {

        Map<String, Object> filterMap = new HashMap<>();
        filterMap.put(NAME_PARAM, name);
        filterMap.put(AGE_PARAM, age);

        return convertAccountsToDTO(studentService.getAll(pageable, filterMap));
    }

    @GetMapping("/studentByHonor")
    public Integer getStudentsByHonor(
            @RequestParam(value = HONOR_PARAM, required = false) String honor) {

        return studentService.getStudentsByHonor(honor);
    }

    @GetMapping("/countByAge")
    public Integer getTotalStudentsByAge(
            @RequestParam(value = AGE_PARAM, required = false) Integer age) {

        return studentService.getCountByAge(age);
    }

}
