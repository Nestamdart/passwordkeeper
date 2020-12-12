package com.olegdev.passwordkeeper.modules.passwords.router;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.olegdev.passwordkeeper.R;

public class PasswordsRouterImpl implements PasswordsRouter {

    @NonNull
    private final Fragment fragment;

    public PasswordsRouterImpl(@NonNull Fragment fragment) {
        this.fragment = fragment;
    }

    @Override
    public void openNewRecordModule() {
        NavHostFragment.findNavController(fragment).navigate(R.id.action_passwordsFragment_to_addRecordFragment);
    }
}
