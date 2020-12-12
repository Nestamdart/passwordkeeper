package com.olegdev.passwordkeeper.modules.addrecord.presenter;

import androidx.annotation.NonNull;

public interface ResourceProvider {
    @NonNull
    String provide(@NonNull Resource resource);

    enum Resource {
        ACCOUNT_ERROR, LOGIN_ERROR, PASSWORD_ERROR;
    }
}
