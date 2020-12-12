package com.olegdev.passwordkeeper.modules.addrecord.router;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

public class AddRecordRouterImpl implements AddRecordRouter {
    @NonNull
    private final Fragment fragment;

    public AddRecordRouterImpl(@NonNull Fragment fragment) {
        this.fragment = fragment;
    }

    @Override
    public void close() {
        NavHostFragment.findNavController(fragment).popBackStack();
    }
}
