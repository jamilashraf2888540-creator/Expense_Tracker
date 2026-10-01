package com.example.expensetracker;

public class TransactionModel {
    private int id;
    private String title;
    private double amount;
    private String type; // دخل أو مصروف
    private String date;

    public TransactionModel(int id, String title, double amount, String type, String date) {
        this.id = id;
        this.title = title;
        this.amount = amount;
        this.type = type;
        this.date = date;
    }

    public int getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public double getAmount() {
        return amount;
    }
    public String getType() {
        return type;
    }
    public String getDate() {
        return date;
    }
}
