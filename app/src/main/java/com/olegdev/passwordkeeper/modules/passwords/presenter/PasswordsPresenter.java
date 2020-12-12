package com.olegdev.passwordkeeper.modules.passwords.presenter;

import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;

import com.olegdev.passwordkeeper.modules.passwords.interactor.PasswordsInteractor;
import com.olegdev.passwordkeeper.modules.passwords.router.PasswordsRouter;
import com.olegdev.passwordkeeper.modules.passwords.view.PasswordViewDelegate;
import com.olegdev.passwordkeeper.modules.passwords.view.PasswordsView;
import com.olegdev.passwordkeeper.storage.entities.PasswordEntity;

import java.util.List;

public class PasswordsPresenter implements PasswordsModule, LifecycleEventObserver, PasswordViewDelegate {
    @NonNull
    private PasswordsView view;
    @NonNull
    private PasswordsInteractor interactor;
    @NonNull
    private PasswordsRouter router;
    @NonNull
    private DataConverter converter;

    public PasswordsPresenter(
            @NonNull PasswordsView view,
            @NonNull PasswordsInteractor interactor,
            @NonNull PasswordsRouter router,
            @NonNull DataConverter converter
    ) {
        this.view = view;
        this.interactor = interactor;
        this.router = router;
        this.converter = converter;

        this.view.getLifecycle().addObserver(this);
        this.view.setDelegate(this);
    }

    @Override
    public void onStateChanged(@NonNull LifecycleOwner source, @NonNull Lifecycle.Event event) {
        if (event == Lifecycle.Event.ON_CREATE) {
            interactor.obtain()
                    .observe(view, passwordEntities -> view.display(converter.convert(passwordEntities)));
        }
    }

    @Override
    public void onAddButtonTapped() {
        router.openNewRecordModule();
    }
}
