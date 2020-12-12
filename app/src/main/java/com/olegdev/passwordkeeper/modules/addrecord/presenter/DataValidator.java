package com.olegdev.passwordkeeper.modules.addrecord.presenter;

import com.olegdev.passwordkeeper.modules.addrecord.view.AddRecordViewModel;

public interface DataValidator {
    boolean isAccountValid(String account);
    boolean isLoginValid(String login);
    boolean isPasswordValid(String password);
    boolean isValid(AddRecordViewModel model);
}
