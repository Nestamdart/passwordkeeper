package com.olegdev.passwordkeeper.storage;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.olegdev.passwordkeeper.storage.entities.PasswordEntity;

@Database(entities = {PasswordEntity.class}, version = 1)
public abstract class PasswordsRoomDatabase extends RoomDatabase {
    abstract RoomPasswordKeeperDao passwordsDao();
}
