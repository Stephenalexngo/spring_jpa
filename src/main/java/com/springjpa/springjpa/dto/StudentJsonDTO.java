package com.springjpa.springjpa.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.springjpa.springjpa.model.Student;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@JsonIgnoreProperties(value = {"id"})
public class StudentJsonDTO extends Student {

//    @JsonIncludeProperties(value = {
//            "studentName", "studentAge"
//    })

    public StudentJsonDTO(Student student) {
        super.setId(student.getId());
        super.setName(student.getName());
        super.setAge(student.getAge());
    }

    @JsonProperty(value = "studentName")
    public String getName() {
        return super.getName();
    }

    @JsonProperty(value = "studentAge")
    public Integer getAge() {
        return super.getAge();
    }
}
