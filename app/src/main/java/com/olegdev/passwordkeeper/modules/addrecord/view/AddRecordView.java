package com.olegdev.passwordkeeper.modules.addrecord.view;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public interface AddRecordView {
    void setDelegate(@Nullable AddRecordViewDelegate delegate);
    void display(@NonNull AddRecordViewModel data);
}
