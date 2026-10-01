package com.example.expensetracker;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class activity_statistics extends AppCompatActivity {

     ImageButton btnBack;

     TextView tvTotalSpent, tvFoodStats , tvTransportStats, tvEducationStats , tvBillsStats , tvChartPlaceholder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);
        findViewById();
        String etAmount = getIntent().getStringExtra("et_Amount");
        String etDate = getIntent().getStringExtra("et_Date");
        String etNote = getIntent().getStringExtra("et_Note");
        String category = getIntent().getStringExtra("category");
        String type = getIntent().getStringExtra("type");
        if (etAmount != null && !etAmount.isEmpty()) {
            tvTotalSpent.setText("$" + etAmount);
        }
        if (category != null && etAmount != null && !etAmount.isEmpty()) {
            if (category.equals("Food")) {
                tvFoodStats.setText("Food                         $" + etAmount);
            } else if (category.equals("Transport")) {
                tvTransportStats.setText("Transport                    $" + etAmount);
            } else if (category.equals("Education")) {
                tvEducationStats.setText("Education                    $" + etAmount);
            } else if (category.equals("Bills")) {
                tvBillsStats.setText("Bills                           $" + etAmount);
            }
        }
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity_statistics.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }

    void findViewById(){
        btnBack = findViewById(R.id.btnBack);
        tvTotalSpent = findViewById(R.id.tvTotalSpent);
        tvFoodStats = findViewById(R.id.tvFoodStats);
        tvTransportStats = findViewById(R.id.tvTransportStats);
        tvEducationStats = findViewById(R.id.tvEducationStats);
        tvBillsStats = findViewById(R.id.tvBillsStats);
        tvChartPlaceholder = findViewById(R.id.tvChartPlaceholder);
    }

}