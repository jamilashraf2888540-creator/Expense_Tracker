package com.example.expensetracker;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class activity_transactions extends AppCompatActivity {

    ImageButton btnBack;
    EditText etSearch;
    RadioGroup filterGroup;
    RadioButton filterAll, filterIncome, filterExpense;
    RecyclerView recyclerTransactions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transactions);
        findViewById();

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity_transactions.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        // إعداد الـ RecyclerView وجلب المعاملات من قاعدة البيانات مباشرة
        recyclerTransactions.setLayoutManager(new LinearLayoutManager(this));

        Database dbHelper = new Database(this);
        List<TransactionModel> transactionList = dbHelper.getAllTransactions();

        Database_Adapter adapter = new Database_Adapter(transactionList);
        recyclerTransactions.setAdapter(adapter);
    }

    void findViewById(){
        btnBack = findViewById(R.id.btnBack);
        etSearch = findViewById(R.id.etSearch);
        filterGroup = findViewById(R.id.filterGroup);
        filterAll = findViewById(R.id.filterAll);
        filterIncome = findViewById(R.id.filterIncome);
        filterExpense = findViewById(R.id.filterExpense);
        recyclerTransactions = findViewById(R.id.recyclerTransactions);
    }
}