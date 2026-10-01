package com.example.expensetracker;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Database_Adapter extends RecyclerView.Adapter<Database_Adapter.ViewHolder>{
    private List<TransactionModel> transactionList;

    public Database_Adapter(List<TransactionModel> transactionList) {
        this.transactionList = transactionList;
    }

    @NonNull
    @Override
    public Database_Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // ربط ملف التصميم المطابق item_transaction_4.xml
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_transaction, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Database_Adapter.ViewHolder holder, int position) {
        TransactionModel model = transactionList.get(position);
        holder.tvTitle.setText(model.getTitle());
        holder.tvAmount.setText("$" + model.getAmount());
        holder.tvDate.setText(model.getDate());
    }

    @Override
    public int getItemCount() {
        return transactionList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle, tvAmount, tvDate, tvIcon;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tvTransactionTitle);
            tvAmount = itemView.findViewById(R.id.tvTransactionAmount);
            tvDate = itemView.findViewById(R.id.tvTransactionDate);
            tvIcon = itemView.findViewById(R.id.tvTransactionIcon);
        }
    }
}