package com.olegdev.passwordkeeper.modules.addrecord.view;

public interface AddRecordViewDelegate {
    void onAccountInputChanged(String text);
    void onLoginInputChanged(String text);
    void onPasswordInputChanged(String text);
    void onSaveButtonTapped();
}
