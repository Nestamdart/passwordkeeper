package com.olegdev.passwordkeeper.modules.passwords.presenter;

import com.olegdev.passwordkeeper.modules.passwords.view.PasswordViewModel;
import com.olegdev.passwordkeeper.storage.entities.PasswordEntity;

import java.util.ArrayList;
import java.util.List;

public class DataConverterImpl implements DataConverter {
    @Override
    public List<PasswordViewModel> convert(List<PasswordEntity> data) {
        List<PasswordViewModel> outData = new ArrayList<>();

        for (int i = 0; i < data.size(); i++) {
            PasswordEntity item = data.get(i);
            outData.add(new PasswordViewModel("Facebook", item.login, item.password));
        }

        return outData;
    }
}
