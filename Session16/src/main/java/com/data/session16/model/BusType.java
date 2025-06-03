package com.data.session16.model;

public enum BusType {
    VIP, LUXURY, NORMAL;

    public static BusType fromString(String type) {
        try {
            return BusType.valueOf(type.trim().toUpperCase());
        } catch (Exception e) {
            throw new IllegalArgumentException("Unknown bus type: " + type);
        }
    }
}
