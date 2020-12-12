package com.olegdev.passwordkeeper.modules.addrecord.interactor;

import androidx.annotation.NonNull;

import com.olegdev.passwordkeeper.storage.PasswordKeeperDao;
import com.olegdev.passwordkeeper.storage.entities.PasswordEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;

public class AddRecordInteractorImpl implements AddRecordInteractor {

    @NonNull
    private final PasswordKeeperDao storage;
    @NonNull
    private ExecutorService backgroundExecutor;

    public AddRecordInteractorImpl(
            @NonNull PasswordKeeperDao storage,
            @NonNull ExecutorService executor
    ) {
        this.storage = storage;
        this.backgroundExecutor = executor;
    }

    @Override
    public void save(@NonNull PasswordEntity entity) {
        backgroundExecutor.execute(() -> {
            List<PasswordEntity> data = new ArrayList<>();
            data.add(entity);
            storage.putPasswords(data);
        });
    }
}
