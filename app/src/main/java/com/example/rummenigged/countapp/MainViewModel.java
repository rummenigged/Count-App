package com.example.rummenigged.countapp;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

/**
 * Created by rummenigged on 12/01/18.
 */

public class MainViewModel extends ViewModel {
    MutableLiveData<Integer> count = new MutableLiveData<>();


    public MainViewModel(int initialValue){
        this.count.setValue(initialValue);
    }

    public MutableLiveData<Integer> getCount(){
        return this.count;
    }

    public void add(){
        this.count.setValue(this.count.getValue() + 1);
    }

    public void remove(){
        this.count.setValue(this.count.getValue() - 1);
    }
}
