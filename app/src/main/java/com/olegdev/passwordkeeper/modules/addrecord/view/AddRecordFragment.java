package com.olegdev.passwordkeeper.modules.addrecord.view;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.textfield.TextInputLayout;
import com.olegdev.passwordkeeper.databinding.AddRecordFragmentBinding;
import com.olegdev.passwordkeeper.modules.addrecord.assamble.AddRecordFactory;
import com.olegdev.passwordkeeper.modules.addrecord.presenter.AddRecordModule;

public class AddRecordFragment extends Fragment implements AddRecordView {
    private AddRecordFragmentBinding binding;

    @Nullable
    private AddRecordViewDelegate delegate;
    private AddRecordModule module;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = AddRecordFragmentBinding.inflate(inflater, container, false);

        module = new AddRecordFactory().make(getContext(), this);
        addListeners();

        return binding.getRoot();
    }

    private void addListeners() {
        binding.accountInput.getEditText().addTextChangedListener(accountTextWatcher);
        binding.loginInput.getEditText().addTextChangedListener(loginTextWatcher);
        binding.passwordInput.getEditText().addTextChangedListener(passwordTextWatcher);
        binding.passwordInput.getEditText().setOnEditorActionListener((v, actionId, event) -> {
            if (actionId == EditorInfo.IME_ACTION_SEND) {
                saveAction();
                return true;
            }
            return false;
        });
        binding.saveButton.setOnClickListener(v -> {
            saveAction();
        });
    }

    private void saveAction() {
        if (delegate != null) {
            delegate.onSaveButtonTapped();
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        removeListeners();
    }

    private void removeListeners() {
        binding.accountInput.getEditText().removeTextChangedListener(accountTextWatcher);
        binding.loginInput.getEditText().removeTextChangedListener(loginTextWatcher);
        binding.passwordInput.getEditText().removeTextChangedListener(passwordTextWatcher);
        binding.passwordInput.getEditText().setOnEditorActionListener(null);
        binding.saveButton.setOnClickListener(null);
    }

    @Override
    public void setDelegate(@Nullable AddRecordViewDelegate delegate) {
        this.delegate = delegate;
    }

    @Override
    public void display(@NonNull AddRecordViewModel data) {
        updateInput(binding.accountInput, data.isAccountFailed());
        updateInput(binding.loginInput, data.isLoginFailed());
        updateInput(binding.passwordInput, data.isPasswordFailed());
    }

    private void updateInput(@NonNull TextInputLayout input, @Nullable String reason) {
        if (reason == null) {
            input.setErrorEnabled(false);
        } else {
            input.setErrorEnabled(true);
            input.setError(reason);
        }
    }
    private final TextWatcher accountTextWatcher = new TextChangedListener() {
        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            if (delegate != null) {
                delegate.onAccountInputChanged(s.toString());
            }
        }
    };

    private final TextWatcher loginTextWatcher = new TextChangedListener() {
        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            if (delegate != null) {
                delegate.onLoginInputChanged(s.toString());
            }
        }
    };

    private final TextWatcher passwordTextWatcher = new TextChangedListener() {
        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            if (delegate != null) {
                delegate.onPasswordInputChanged(s.toString());
            }
        }
    };

    private abstract static class TextChangedListener implements TextWatcher {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

        @Override
        public void afterTextChanged(Editable s) { }
    }
}
