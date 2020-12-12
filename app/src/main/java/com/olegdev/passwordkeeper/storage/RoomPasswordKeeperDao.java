package com.olegdev.passwordkeeper.storage;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.olegdev.passwordkeeper.storage.entities.PasswordEntity;

import java.util.List;

@Dao
public abstract class RoomPasswordKeeperDao implements PasswordKeeperDao {
    @Query("SELECT * FROM passwords")
    public abstract LiveData<List<PasswordEntity>> passwords();

    @Insert
    public abstract void putPasswords(List<PasswordEntity> passwords);

    @Query("DELETE FROM passwords")
    public abstract void deleteAllPasswords();
}
