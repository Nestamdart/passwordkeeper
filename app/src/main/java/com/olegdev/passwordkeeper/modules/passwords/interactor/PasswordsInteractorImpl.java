package com.olegdev.passwordkeeper.modules.passwords.interactor;

import androidx.lifecycle.LiveData;

import com.olegdev.passwordkeeper.storage.PasswordKeeperDao;
import com.olegdev.passwordkeeper.storage.RoomPasswordsStorage;
import com.olegdev.passwordkeeper.storage.entities.PasswordEntity;

import java.util.List;

public class PasswordsInteractorImpl implements PasswordsInteractor {

    private PasswordKeeperDao storage;

    public PasswordsInteractorImpl(PasswordKeeperDao storage) {
        this.storage = storage;
    }

    @Override
    public LiveData<List<PasswordEntity>> obtain() {
        return storage.passwords();
    }
}
