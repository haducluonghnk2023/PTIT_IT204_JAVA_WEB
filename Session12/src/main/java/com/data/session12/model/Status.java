package com.data.session12.model;

public enum Status {
    ACTIVE,INACTIVE;
    public static Status fromString(String status) {
        if (status == null) {
            return null;
        }
        try {
            return Status.valueOf(status.toUpperCase());
        } catch (IllegalArgumentException e) {
            return null;
        }
    }
    @Override
    public String toString() {
        return name().toLowerCase();
    }

}
