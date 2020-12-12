package com.olegdev.passwordkeeper.modules.addrecord.presenter;

import androidx.annotation.NonNull;

import com.olegdev.passwordkeeper.modules.addrecord.view.AddRecordViewModel;
import com.olegdev.passwordkeeper.modules.addrecord.view.AddRecordViewModel.InputData;
import com.olegdev.passwordkeeper.storage.entities.PasswordEntity;

import static com.olegdev.passwordkeeper.modules.addrecord.presenter.ResourceProvider.Resource.ACCOUNT_ERROR;
import static com.olegdev.passwordkeeper.modules.addrecord.presenter.ResourceProvider.Resource.LOGIN_ERROR;
import static com.olegdev.passwordkeeper.modules.addrecord.presenter.ResourceProvider.Resource.PASSWORD_ERROR;

public class DataConverterImpl implements DataConverter {
    @NonNull
    private DataValidator dataValidator;

    @NonNull
    private ResourceProvider resourceProvider;

    public DataConverterImpl(
            @NonNull DataValidator dataValidator,
            @NonNull ResourceProvider resourceProvider) {
        this.dataValidator = dataValidator;
        this.resourceProvider = resourceProvider;
    }

    @NonNull
    @Override
    public AddRecordViewModel convertToViewModel(
            @NonNull String account,
            @NonNull String login,
            @NonNull String password
    ) {
        InputData accountInput;
        if (dataValidator.isAccountValid(account)) {
            accountInput = new InputData(null);
        } else {
            accountInput = new InputData(resourceProvider.provide(ACCOUNT_ERROR));
        }

        InputData loginInput;
        if (dataValidator.isLoginValid(login)) {
            loginInput = new InputData(null);
        } else {
            loginInput = new InputData(resourceProvider.provide(LOGIN_ERROR));
        }

        InputData passwordInput;
        if (dataValidator.isPasswordValid(password)) {
            passwordInput = new InputData(null);
        } else {
            passwordInput = new InputData(resourceProvider.provide(PASSWORD_ERROR));
        }

        return new AddRecordViewModel(accountInput, loginInput, passwordInput);
    }

    @NonNull
    @Override
    public PasswordEntity convertToEntity(
            @NonNull String account,
            @NonNull String login,
            @NonNull String password
    ) {
        PasswordEntity entity = new PasswordEntity();
        entity.login = login;
        entity.password = password;
        return entity;
    }
}
