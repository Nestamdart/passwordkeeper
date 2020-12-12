package com.olegdev.passwordkeeper.modules.addrecord.presenter;

import com.olegdev.passwordkeeper.modules.addrecord.view.AddRecordViewModel;

public class DataValidatorImpl implements  DataValidator {
    @Override
    public boolean isAccountValid(String account) {
        return account.length() > 0;
    }

    @Override
    public boolean isLoginValid(String login) {
        return login.length() > 0;
    }

    @Override
    public boolean isPasswordValid(String password) {
        return matchPasswordRegex(password);
    }

    @Override
    public boolean isValid(AddRecordViewModel model) {
        return model.isValid();
    }

    private boolean matchPasswordRegex(String password) {
        return password.length() > 0;
    }
}
