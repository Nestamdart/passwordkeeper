package com.olegdev.passwordkeeper.modules.passwords.view;

public class PasswordViewModel {
    public String account;
    public String login;
    public String password;

    public PasswordViewModel(
            String account,
            String login,
            String password
    ) {
        this.account = account;
        this.login = login;
        this.password = password;
    }
}
