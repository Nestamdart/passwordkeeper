package com.olegdev.passwordkeeper.storage;

import androidx.lifecycle.LiveData;

import com.olegdev.passwordkeeper.storage.entities.PasswordEntity;

import java.util.List;

public interface PasswordKeeperDao {
    LiveData<List<PasswordEntity>> passwords();
    void putPasswords(List<PasswordEntity> passwords);
    void deleteAllPasswords();
}
