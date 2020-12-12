package com.olegdev.passwordkeeper.modules.passwords.interactor;

import androidx.lifecycle.LiveData;

import com.olegdev.passwordkeeper.storage.entities.PasswordEntity;

import java.util.List;

public interface PasswordsInteractor {
     LiveData<List<PasswordEntity>> obtain();
}
