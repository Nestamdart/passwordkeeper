package com.olegdev.passwordkeeper;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.olegdev.passwordkeeper.storage.PasswordKeeperDao;
import com.olegdev.passwordkeeper.storage.PasswordsStorageFactory;
import com.olegdev.passwordkeeper.storage.StorageProvider;

public class PasswordKeeperApplication extends Application implements StorageProvider {
    @Nullable
    private PasswordKeeperDao storage;

    @Override
    @NonNull
    public PasswordKeeperDao provideStorage() {
        if (storage == null) {
            storage = new PasswordsStorageFactory().createStorage(this);
        }
        return storage;
    }
}
