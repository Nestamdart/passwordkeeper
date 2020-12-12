package com.olegdev.passwordkeeper.modules.passwords.view;

import androidx.annotation.Nullable;
import androidx.lifecycle.LifecycleOwner;

import java.util.List;

public interface PasswordsView extends LifecycleOwner {
    void setDelegate(@Nullable PasswordViewDelegate delegate);
    void display(List<PasswordViewModel> data);
}
