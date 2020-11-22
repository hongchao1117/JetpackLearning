package com.hongchao.livedatatest;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

/**
 * @author 洪超
 */
public class ViewModelWithLiveData extends ViewModel {
    private MutableLiveData<Integer> likedNumber;

    public MutableLiveData<Integer> getLikedNumber() {
        if (likedNumber==null){
            likedNumber = new MutableLiveData<>();
            likedNumber.setValue(0);
        }
        return likedNumber;
    }

    public void add(int n) {
       likedNumber.setValue(likedNumber.getValue()+n);
    }
}
