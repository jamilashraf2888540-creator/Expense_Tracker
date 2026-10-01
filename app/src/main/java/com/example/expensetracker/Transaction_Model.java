package com.example.expensetracker;

public class Transaction_Model {

     String category; // الفئة (مثل: Food, Transport, ...)
     String date;     // التاريخ
     String amount;   // المبلغ
     String type;     // النوع ("Income" أو "Expense")
     String note;     // الملاحظة

    // Constructor (المشيد) لتمرير القيم عند إنشاء كائن جديد
    public Transaction_Model(String category, String date, String amount, String type, String note) {
        this.category = category;
        this.date = date;
        this.amount = amount;
        this.type = type;
        this.note = note;
    }

}
