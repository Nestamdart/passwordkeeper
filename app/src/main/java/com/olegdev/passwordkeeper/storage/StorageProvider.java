package com.olegdev.passwordkeeper.storage;

import androidx.annotation.NonNull;

public interface StorageProvider {
    @NonNull
    PasswordKeeperDao provideStorage();
}
