package com.olegdev.passwordkeeper.modules.addrecord.presenter;

import android.content.Context;

import androidx.annotation.NonNull;

import com.olegdev.passwordkeeper.R;

public class ResourceProviderImpl implements ResourceProvider {
    @NonNull
    private final Context context;

    public ResourceProviderImpl(@NonNull Context context) {
        this.context = context;
    }

    @Override
    @NonNull
    public String provide(@NonNull Resource resource) {
        switch (resource) {
            case ACCOUNT_ERROR: return context.getString(R.string.account_validation_error);
            case LOGIN_ERROR: return context.getString(R.string.login_validation_error);
            case PASSWORD_ERROR: return context.getString(R.string.password_validation_error);
        }
        return "";
    }
}
