package com.olegdev.passwordkeeper.modules.addrecord.presenter;

import androidx.annotation.NonNull;

import com.olegdev.passwordkeeper.modules.addrecord.view.AddRecordViewModel;
import com.olegdev.passwordkeeper.storage.entities.PasswordEntity;

public interface DataConverter {
    @NonNull
    AddRecordViewModel convertToViewModel(@NonNull String account, @NonNull String login, @NonNull String password);

    @NonNull
    PasswordEntity convertToEntity(@NonNull String account, @NonNull String login, @NonNull String password);
}
