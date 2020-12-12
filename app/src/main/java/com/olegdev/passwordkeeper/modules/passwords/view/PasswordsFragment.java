package com.olegdev.passwordkeeper.modules.passwords.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.olegdev.passwordkeeper.R;
import com.olegdev.passwordkeeper.databinding.PasswordsFragmentBinding;
import com.olegdev.passwordkeeper.modules.passwords.assamble.PasswordsFactory;
import com.olegdev.passwordkeeper.modules.passwords.presenter.PasswordsModule;

import java.util.List;

public class PasswordsFragment extends Fragment implements PasswordsView {
    private PasswordsViewAdapter adapter;
    private PasswordsFragmentBinding binding;
    private PasswordsModule passwordsModule;
    @Nullable
    private  PasswordViewDelegate delegate;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = PasswordsFragmentBinding.inflate(inflater, container, false);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        binding.passwordsListRecycler.setLayoutManager(linearLayoutManager);
        adapter = new PasswordsViewAdapter();
        binding.passwordsListRecycler.setAdapter(adapter);
        passwordsModule = new PasswordsFactory().make(getContext(), this);
        binding.fab.setOnClickListener(v -> {
            if (delegate != null) {
                delegate.onAddButtonTapped();
            }
        });

        return binding.getRoot();
    }

    @Override
    public void setDelegate(@Nullable PasswordViewDelegate delegate) {
        this.delegate = delegate;
    }

    @Override
    public void display(List<PasswordViewModel> data) {
        adapter.submit(data);
    }
}
