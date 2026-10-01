package com.example.expensetracker;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;

public class activity_add_transaction extends AppCompatActivity {

    RadioGroup radioType;
    RadioButton radioExpense, radioIncome;
    EditText etAmount, etDate, etNote;
    Spinner spinnerCategory;
    MaterialButton btnSaveTransaction;
    ImageButton btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_transaction);
        findViewById();

        radioType.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == R.id.radioExpense){
                Toast.makeText(this, "Expense selected", Toast.LENGTH_SHORT).show();
            } else if (checkedId == R.id.radioIncome){
                Toast.makeText(this, "Income selected", Toast.LENGTH_SHORT).show();
            }
        });

        btnSaveTransaction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String amountStr = etAmount.getText().toString().trim();
                String date = etDate.getText().toString().trim();
                String note = etNote.getText().toString().trim();
                String category = spinnerCategory.getSelectedItem() != null ? spinnerCategory.getSelectedItem().toString() : "Other";
                String type = radioExpense.isChecked() ? "Expense" : "Income";

                if (amountStr.isEmpty()) {
                    Toast.makeText(activity_add_transaction.this, "الرجاء إدخال المبلغ", Toast.LENGTH_SHORT).show();
                    return;
                }

                double amount = Double.parseDouble(amountStr);

                // استخدام الـ Context الصحيح
                Database dbHelper = new Database(activity_add_transaction.this);
                boolean isInserted = dbHelper.insertTransaction(category, amount, type, date);

                if(isInserted) {
                    Toast.makeText(activity_add_transaction.this, "تم الحفظ بنجاح", Toast.LENGTH_SHORT).show();
                    // الانتقال لواجهة المعاملات بعد الحفظ
                    Intent intent = new Intent(activity_add_transaction.this, activity_transactions.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(activity_add_transaction.this, "فشل في الحفظ", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity_add_transaction.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    void findViewById(){
        radioType = findViewById(R.id.radioType);
        radioExpense = findViewById(R.id.radioExpense);
        radioIncome = findViewById(R.id.radioIncome);
        etAmount = findViewById(R.id.etAmount);
        etDate = findViewById(R.id.etDate);
        etNote = findViewById(R.id.etNote);
        spinnerCategory = findViewById(R.id.spinnerCategory);
        btnSaveTransaction = findViewById(R.id.btnSaveTransaction);
        btnBack = findViewById(R.id.btnBack);
    }
}