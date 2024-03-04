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
public class Student {

    @Id
    @GeneratedValue
    private UUID id;
    private String name;
    private Integer age;
    @Enumerated(EnumType.STRING)
    private Honor honor;
}
