package com.daya.nodo.data;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.daya.nodo.model.NoDo;

@Database(entities = {NoDo.class},version = 1)
public abstract class NoDoRoomDataBase extends RoomDatabase {

    public static volatile NoDoRoomDataBase INSTANCE;
    public abstract NoDoDao noDoDao();
    public static NoDoRoomDataBase getDatabase(final Context context){

        if(INSTANCE == null){
            synchronized (NoDoRoomDataBase.class){

                if(INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),NoDoRoomDataBase.class
                    ,"nodo_database").addCallback(roomDatabaseCallback).build();
                }
            }
        }
        return INSTANCE;
    }
    private static RoomDatabase.Callback roomDatabaseCallback =
            new RoomDatabase.Callback(){
                @Override
                public void onOpen(@NonNull SupportSQLiteDatabase db) {
                    super.onOpen(db);
                    new PopulateDbAsync(INSTANCE).execute();
                }
            };

    private static class PopulateDbAsync extends AsyncTask<Void,Void,Void> {
        private NoDoDao noDoDao;
        public PopulateDbAsync(NoDoRoomDataBase db) {
            noDoDao = db.noDoDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {

            return null;
        }
    }
}
