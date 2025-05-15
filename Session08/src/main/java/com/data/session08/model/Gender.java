package com.data.session08.model;

public enum Gender {
    MALE,FEMALE,OTHER;

    public static Gender fromString(String value) {
        return Gender.valueOf(value.toUpperCase());
    }
}
