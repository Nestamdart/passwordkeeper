package com.olegdev.passwordkeeper.storage;

import android.content.Context;

import androidx.room.Room;

public class PasswordsStorageFactory {
    public PasswordKeeperDao createStorage(Context context) {
        return new RoomPasswordsStorage(
                Room.databaseBuilder(
                        context.getApplicationContext(),
                        PasswordsRoomDatabase.class,
                        "passwords.db"
                        )
                .build()
        );
    }
}
