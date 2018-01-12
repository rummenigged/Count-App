package com.example.rummenigged.countapp;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

/**
 * Created by rummenigged on 12/01/18.
 */

public class MainViewModelFactory implements ViewModelProvider.Factory{

    private int initialValue;

    public MainViewModelFactory(int initialValue){
        this.initialValue = initialValue;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(MainViewModel.class)) {
            return (T) new MainViewModel(initialValue);
        }

        throw new IllegalArgumentException("Unknow ViewModel class");
    }
}
