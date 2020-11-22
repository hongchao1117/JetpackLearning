package com.hongchao.databindingtest;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/**
 * @author 洪超
 * @time 2020/5/17 16:47
 */
public class MyViewModel extends ViewModel {
    private MutableLiveData<Integer> number;

    public MutableLiveData<Integer> getNumber() {
        if (number==null){
            number = new MutableLiveData<>();
            number.setValue(0);
        }
        return number;
    }

    public void add(){
        number.setValue(number.getValue()+1);
    }

}
