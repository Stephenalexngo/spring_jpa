package com.springjpa.springjpa.util;

import com.springjpa.springjpa.model.Honor;

import java.util.Objects;

public class EnumUtils {

    private EnumUtils() {}

    public static Honor honorEnum(Honor enumValue) {
        // Set default value if honor is null
        return Objects.nonNull(enumValue) ? enumValue : Honor.NH;
    }
}
