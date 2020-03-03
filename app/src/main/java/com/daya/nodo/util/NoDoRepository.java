package com.daya.nodo.util;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.daya.nodo.data.NoDoDao;
import com.daya.nodo.data.NoDoRoomDataBase;
import com.daya.nodo.model.NoDo;

import java.util.List;

public class NoDoRepository {
    private NoDoDao noDoDao;
    private LiveData<List<NoDo>> allNoDos;
    public NoDoRepository(Application application){
        NoDoRoomDataBase db = NoDoRoomDataBase.getDatabase(application);
        noDoDao = db.noDoDao();
        allNoDos = noDoDao.getAllNoDo();
    }

    public LiveData<List<NoDo>> getAllNoDos(){
        return allNoDos;
    }
    public void insert(NoDo noDo){
        new insertAsyncTask(noDoDao).execute(noDo);
    }

    private class insertAsyncTask extends AsyncTask<NoDo,Void,Void> {
        private NoDoDao asyncTaskDao;
        public insertAsyncTask(NoDoDao taskDao) {
            asyncTaskDao = taskDao;
        }

        @Override
        protected Void doInBackground(NoDo... params) {

            asyncTaskDao.InsertNoDo(params[0]);
            return null;

        }
    }
}
