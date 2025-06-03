package com.data.session08.model;

public enum CustomerType {
    STANDARD,VIP;

    public static CustomerType fromString(String value) {
        return CustomerType.valueOf(value.toUpperCase());
    }
}
