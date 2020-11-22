package com.hongchao.viewmodelshp;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.SavedStateHandle;

/**
 * @author 洪超
 * @time 2020/5/18 17:31
 */
public class MyViewModel extends AndroidViewModel {
    private SavedStateHandle handle;
    String key = getApplication().getResources().getString(R.string.data_key);
    String shpName = getApplication().getResources().getString(R.string.shp_name);

    public MyViewModel(@NonNull Application application, SavedStateHandle handle) {
        super(application);
        this.handle = handle;
        if (!handle.contains(key)){
            load();
        }
    }

    private void load() {
        SharedPreferences shp = getApplication().getSharedPreferences(shpName, Context.MODE_PRIVATE);
        int x = shp.getInt(key,0);
        handle.set(key,x);
    }

    public void save(){
        SharedPreferences shp = getApplication().getSharedPreferences(shpName, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = shp.edit();
        editor.putInt(key,getNumber().getValue());
        editor.apply();
    }

   public LiveData<Integer> getNumber(){
        return handle.getLiveData(key);
    }

   public void add(int x){
        handle.set(key,getNumber().getValue()+x);
    }
}
