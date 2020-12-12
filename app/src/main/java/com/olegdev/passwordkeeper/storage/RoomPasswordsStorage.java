package com.olegdev.passwordkeeper.storage;

import androidx.lifecycle.LiveData;

import com.olegdev.passwordkeeper.storage.entities.PasswordEntity;

import java.util.List;

public class RoomPasswordsStorage implements PasswordKeeperDao {
    private final PasswordKeeperDao dao;
    public RoomPasswordsStorage(PasswordsRoomDatabase db) {
        this.dao = db.passwordsDao();
    }

    @Override
    public LiveData<List<PasswordEntity>> passwords() {
        return dao.passwords();
    }

    @Override
    public void putPasswords(List<PasswordEntity> passwords) {
        dao.putPasswords(passwords);
    }

    @Override
    public void deleteAllPasswords() {
        dao.deleteAllPasswords();
    }
}
