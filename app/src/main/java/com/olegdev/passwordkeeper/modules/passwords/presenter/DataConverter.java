package com.olegdev.passwordkeeper.modules.passwords.presenter;

import androidx.lifecycle.ViewModel;

import com.olegdev.passwordkeeper.modules.passwords.view.PasswordViewModel;
import com.olegdev.passwordkeeper.storage.entities.PasswordEntity;

import java.util.List;

public interface DataConverter {
    List<PasswordViewModel> convert(List<PasswordEntity> data);
}
