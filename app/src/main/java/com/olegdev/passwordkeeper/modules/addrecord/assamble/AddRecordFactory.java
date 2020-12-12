package com.olegdev.passwordkeeper.modules.addrecord.assamble;

import android.content.Context;

import androidx.annotation.NonNull;

import com.olegdev.passwordkeeper.PasswordKeeperApplication;
import com.olegdev.passwordkeeper.modules.addrecord.interactor.AddRecordInteractor;
import com.olegdev.passwordkeeper.modules.addrecord.interactor.AddRecordInteractorImpl;
import com.olegdev.passwordkeeper.modules.addrecord.presenter.AddRecordModule;
import com.olegdev.passwordkeeper.modules.addrecord.presenter.AddRecordPresenter;
import com.olegdev.passwordkeeper.modules.addrecord.presenter.DataConverter;
import com.olegdev.passwordkeeper.modules.addrecord.presenter.DataConverterImpl;
import com.olegdev.passwordkeeper.modules.addrecord.presenter.DataValidator;
import com.olegdev.passwordkeeper.modules.addrecord.presenter.DataValidatorImpl;
import com.olegdev.passwordkeeper.modules.addrecord.presenter.ResourceProvider;
import com.olegdev.passwordkeeper.modules.addrecord.presenter.ResourceProviderImpl;
import com.olegdev.passwordkeeper.modules.addrecord.router.AddRecordRouter;
import com.olegdev.passwordkeeper.modules.addrecord.router.AddRecordRouterImpl;
import com.olegdev.passwordkeeper.modules.addrecord.view.AddRecordFragment;

import java.util.concurrent.Executors;

public class AddRecordFactory {
    @NonNull
    public AddRecordModule make(@NonNull Context context, @NonNull AddRecordFragment view) {
        PasswordKeeperApplication appContext = (PasswordKeeperApplication) context.getApplicationContext();

        AddRecordInteractor interactor = new AddRecordInteractorImpl(
                appContext.provideStorage(),
                Executors.newCachedThreadPool()
        );
        AddRecordRouter router = new AddRecordRouterImpl(view);
        ResourceProvider resourceProvider = new ResourceProviderImpl(context);
        DataValidator validator = new DataValidatorImpl();
        DataConverter converter = new DataConverterImpl(validator, resourceProvider);

        return new AddRecordPresenter(view, interactor, router, validator, converter);
    }
}
