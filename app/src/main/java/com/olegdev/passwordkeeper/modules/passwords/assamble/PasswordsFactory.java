package com.olegdev.passwordkeeper.modules.passwords.assamble;

import android.content.Context;

import androidx.annotation.NonNull;

import com.olegdev.passwordkeeper.PasswordKeeperApplication;
import com.olegdev.passwordkeeper.modules.passwords.interactor.PasswordsInteractor;
import com.olegdev.passwordkeeper.modules.passwords.interactor.PasswordsInteractorImpl;
import com.olegdev.passwordkeeper.modules.passwords.presenter.DataConverter;
import com.olegdev.passwordkeeper.modules.passwords.presenter.DataConverterImpl;
import com.olegdev.passwordkeeper.modules.passwords.presenter.PasswordsPresenter;
import com.olegdev.passwordkeeper.modules.passwords.router.PasswordsRouter;
import com.olegdev.passwordkeeper.modules.passwords.router.PasswordsRouterImpl;
import com.olegdev.passwordkeeper.modules.passwords.view.PasswordsFragment;

public class PasswordsFactory {
    @NonNull
    public PasswordsPresenter make(@NonNull Context context, @NonNull PasswordsFragment view) {
        PasswordKeeperApplication appContext = (PasswordKeeperApplication) context.getApplicationContext();
        PasswordsInteractor interactor = new PasswordsInteractorImpl(appContext.provideStorage());
        PasswordsRouter router = new PasswordsRouterImpl(view);
        DataConverter converter = new DataConverterImpl();
        return new PasswordsPresenter(view, interactor, router, converter);
    }
}
