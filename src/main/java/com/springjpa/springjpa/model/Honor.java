package com.springjpa.springjpa.model;

import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;
import lombok.Getter;

@Getter
public enum Honor {

    @JsonEnumDefaultValue
    NH("No Honor", "NH"),
    HM("Honorable Mention", "HM"),
    CL("Cum Laude", "CL"),
    MCL("Magna Cum Laude", "MCL"),
    SCL("Summa Cum Laude", "SCL");

    private final String honorRankName;

    private final String honorCode;

    Honor(String honorRankName, String honorCode) {
        this.honorRankName = honorRankName;
        this.honorCode = honorCode;
    }
}
