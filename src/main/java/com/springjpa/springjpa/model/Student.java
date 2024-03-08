package com.springjpa.springjpa.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@ToString
@Builder
@Table(name = "student")
//@NamedStoredProcedureQuery(name = "getStudentCountByAge",
//        procedureName = "GET_TOTAL_STUDENT_BY_AGE", parameters = {
//        @StoredProcedureParameter(mode = ParameterMode.IN, name = "age_in", type = Integer.class),
//        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "num_of_student_out", type = Integer.class)
//})
public class Student {

    @Id
    @GeneratedValue
    private UUID id;
    private String name;
    private Integer age;
    @Enumerated(EnumType.STRING)
    private Honor honor;
}
