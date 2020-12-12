package com.olegdev.passwordkeeper.modules.passwords.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.olegdev.passwordkeeper.R;

import java.util.ArrayList;
import java.util.List;

public class PasswordsViewAdapter extends RecyclerView.Adapter<PasswordItemViewHolder> {

    private List<PasswordViewModel> models = new ArrayList<>();

    @NonNull
    @Override
    public PasswordItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.password_item, parent, false);
        return new PasswordItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PasswordItemViewHolder holder, int position) {
        holder.bindTo(models.get(position));
    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    public void submit(List<PasswordViewModel> models) {
        this.models = models;
        notifyDataSetChanged();
    }
}
