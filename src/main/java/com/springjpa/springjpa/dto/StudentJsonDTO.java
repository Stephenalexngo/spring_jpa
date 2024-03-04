package com.springjpa.springjpa.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.springjpa.springjpa.model.Honor;
import com.springjpa.springjpa.model.Student;
import com.springjpa.springjpa.util.EnumUtils;
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
        super.setHonor(student.getHonor());
    }

    @JsonProperty(value = "studentName")
    public String getName() {
        return super.getName();
    }

    @JsonProperty(value = "studentAge")
    public Integer getAge() {
        return super.getAge();
    }

    @JsonProperty(value = "honorCode")
    public Honor getHonor() {
        return EnumUtils.honorEnum(super.getHonor());
    }

    @JsonProperty(value = "honorName")
    public String getHonorName() {
        return EnumUtils.honorEnum(super.getHonor()).getHonorRankName();
    }
}
