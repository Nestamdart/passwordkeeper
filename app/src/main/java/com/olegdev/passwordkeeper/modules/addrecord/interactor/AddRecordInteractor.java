package com.olegdev.passwordkeeper.modules.addrecord.interactor;

import androidx.annotation.NonNull;

import com.olegdev.passwordkeeper.storage.entities.PasswordEntity;

public interface AddRecordInteractor {
    void save(@NonNull PasswordEntity entity);
}
