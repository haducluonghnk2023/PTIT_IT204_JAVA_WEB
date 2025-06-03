package com.data.session04.model;

public class MonthRevenue {
    private String month;
    private double revenue;

    public MonthRevenue(String month, double revenue) {
        this.month = month;
        this.revenue = revenue;
    }

    public String getMonth() {
        return month;
    }

    public double getRevenue() {
        return revenue;
    }
}
