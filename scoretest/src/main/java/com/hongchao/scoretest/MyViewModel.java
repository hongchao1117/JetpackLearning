package com.hongchao.scoretest;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;

import java.security.Key;

/**
 * @author 洪超
 * @time 2020/5/18 10:23
 */
public class MyViewModel extends ViewModel {
    private MutableLiveData<Integer> aTeamScore;
    private MutableLiveData<Integer> bTeamScore;
    private int aBack, bBack;
    private SavedStateHandle handle;

    public MyViewModel(SavedStateHandle handle) {
        this.handle = handle;
    }

    public MutableLiveData<Integer> getaTeamScore() {
        if (!handle.contains(MainActivity.A_NUMBER)) {
            handle.set(MainActivity.A_NUMBER, 0);
        }
        return handle.getLiveData(MainActivity.A_NUMBER);
        /** if (aTeamScore==null){
         aTeamScore = new MutableLiveData<>();
         aTeamScore.setValue(0);
         }
         return aTeamScore;*/
    }

    public MutableLiveData<Integer> getbTeamScore() {
        if (!handle.contains(MainActivity.B_NUMBER)) {
            handle.set(MainActivity.B_NUMBER, 0);
        }
        return handle.getLiveData(MainActivity.B_NUMBER);
        /**  if (bTeamScore==null){
         bTeamScore = new MutableLiveData<>();
         bTeamScore.setValue(0);
         }
         return bTeamScore;*/
    }

    public void aTeamAdd(int p) {
        /** aBack = aTeamScore.getValue();
         bBack = bTeamScore.getValue();
         aTeamScore.setValue(aTeamScore.getValue()+p);*/
        getaTeamScore().setValue(getaTeamScore().getValue() + 1);
    }

    public void bTeamAdd(int p) {
        // bTeamScore.setValue(bTeamScore.getValue()+p);
        getbTeamScore().setValue(getbTeamScore().getValue() + 1);
    }

    public void reset(){
     aBack = aTeamScore.getValue();
     bBack = bTeamScore.getValue();
     aTeamScore.setValue(0);
     bTeamScore.setValue(0);
     }

     public void undo(){
     aTeamScore.setValue(aBack);
     bTeamScore.setValue(bBack);
     }
}

