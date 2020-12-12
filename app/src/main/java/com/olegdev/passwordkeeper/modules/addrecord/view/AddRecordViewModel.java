package com.olegdev.passwordkeeper.modules.addrecord.view;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class AddRecordViewModel {
    @NonNull
    private final InputData account;
    @NonNull
    private final InputData login;
    @NonNull
    private final InputData password;

    public AddRecordViewModel(@NonNull InputData account, @NonNull InputData login, @NonNull InputData password) {
        this.account = account;
        this.login = login;
        this.password = password;
    }

    @Nullable
    String isAccountFailed() {
        return account.failReason();
    }

    @Nullable
    String isLoginFailed() {
        return login.failReason();
    }

    @Nullable
    String isPasswordFailed() {
        return password.failReason();
    }

    public boolean isValid() {
        return isAccountFailed() == null && isLoginFailed() == null && isPasswordFailed() == null;
    }

    public static class InputData {
        @Nullable
        private final String message;

        public InputData(@Nullable String message) {
            this.message = message;
        }

        @Nullable
        public String failReason() {
            return message;
        }
    }
}
