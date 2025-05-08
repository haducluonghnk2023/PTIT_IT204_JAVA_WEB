package com.data.session03.model;

public class OrderProcessor {
    public static double calculateTotal(String[] quantities, String[] prices) {
        double total = 0;
        try {
            for (int i = 0; i < quantities.length; i++) {
                int qty = Integer.parseInt(quantities[i]);
                double price = Double.parseDouble(prices[i]);
                total += qty * price;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return total;
    }
}
