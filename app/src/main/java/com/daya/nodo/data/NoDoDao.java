package com.daya.nodo.data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.daya.nodo.model.NoDo;

import java.util.List;

@Dao
public interface NoDoDao {

    @Insert
    void InsertNoDo(NoDo noDo);

    @Query("DELETE FROM nodo_table")
    void DeleteAll();

    @Query("DELETE FROM nodo_table WHERE id = :id")
    void DeleteANoDo(int id);

    @Query("UPDATE nodo_table SET nodo_col = :nodoText WHERE id = :id")
    void updateNoDo(int id,String nodoText);

    @Query("SELECT * FROM nodo_table ORDER BY nodo_col DESC")
    LiveData<List<NoDo>> getAllNoDo();
}
