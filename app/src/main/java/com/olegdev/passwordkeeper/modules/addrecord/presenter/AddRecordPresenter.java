package com.olegdev.passwordkeeper.modules.addrecord.presenter;

import androidx.annotation.NonNull;

import com.olegdev.passwordkeeper.modules.addrecord.interactor.AddRecordInteractor;
import com.olegdev.passwordkeeper.modules.addrecord.router.AddRecordRouter;
import com.olegdev.passwordkeeper.modules.addrecord.view.AddRecordView;
import com.olegdev.passwordkeeper.modules.addrecord.view.AddRecordViewDelegate;
import com.olegdev.passwordkeeper.modules.addrecord.view.AddRecordViewModel;

public class AddRecordPresenter implements AddRecordModule, AddRecordViewDelegate {
    @NonNull
    private final AddRecordView view;
    @NonNull
    private final AddRecordInteractor interactor;
    @NonNull
    private final AddRecordRouter router;
    @NonNull
    private final DataValidator dataValidator;
    @NonNull
    private final DataConverter dataConverter;

    @NonNull
    private final EnteredData enteredData = new EnteredData();

    public AddRecordPresenter(
            @NonNull AddRecordView view,
            @NonNull AddRecordInteractor interactor,
            @NonNull AddRecordRouter router,
            @NonNull DataValidator dataValidator,
            @NonNull DataConverter dataConverter
    ) {
        this.view = view;
        this.interactor = interactor;
        this.router = router;
        this.dataValidator = dataValidator;
        this.dataConverter = dataConverter;

        this.view.setDelegate(this);
    }

    @Override
    public void onAccountInputChanged(String text) {
        enteredData.account = text;
        updateViewState();
    }

    @Override
    public void onLoginInputChanged(String text) {
        enteredData.login = text;
        updateViewState();
    }

    @Override
    public void onPasswordInputChanged(String text) {
        enteredData.password = text;
        updateViewState();
    }

    private void updateViewState() {
        AddRecordViewModel viewModel = dataConverter.convertToViewModel(
                enteredData.account,
                enteredData.login,
                enteredData.password
        );
        view.display(viewModel);
    }
    @Override
    public void onSaveButtonTapped() {
        AddRecordViewModel viewModel = dataConverter.convertToViewModel(
                enteredData.account,
                enteredData.login,
                enteredData.password
        );
        if (dataValidator.isValid(viewModel)) {
            interactor.save(
                    dataConverter.convertToEntity(
                            enteredData.account,
                            enteredData.login,
                            enteredData.password
                    )
            );
            router.close();
        } else {
            view.display(viewModel);
        }
    }

    private static class EnteredData {
        private String account = "";
        private String login = "";
        private String password = "";
    }
}
