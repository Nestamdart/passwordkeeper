package com.olegdev.passwordkeeper.modules.passwords.view;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.olegdev.passwordkeeper.databinding.PasswordItemBinding;

public class PasswordItemViewHolder extends RecyclerView.ViewHolder {
    private final PasswordItemBinding binding;

    public PasswordItemViewHolder(@NonNull View itemView) {
        super(itemView);
        binding = PasswordItemBinding.bind(itemView);
    }

    void bindTo(PasswordViewModel model) {
        binding.accountName.setText(model.account);
        binding.accountLogin.setText(model.login);
        binding.accountPassword.setText(model.password);
    }
}
