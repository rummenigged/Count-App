package com.example.rummenigged.countapp;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProviders;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private ImageView ivAdd;
    private ImageView ivRemove;
    private TextView tvCount;
    private MainViewModel viewModel;
    private Observer<Integer> changeCountObserver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setUpUI();

        MainViewModelFactory factory = new MainViewModelFactory(5);
        viewModel = ViewModelProviders.of(this, factory).get(MainViewModel.class);

        changeCountObserver = count -> tvCount.setText(String.valueOf(count));

        setUpObservers();
    }

    private void setUpUI(){
        ivAdd = findViewById(R.id.iv_add);
        ivRemove = findViewById(R.id.iv_remove);
        tvCount = findViewById(R.id.tv_count);
        setUpEvents();
    }

    private void setUpEvents(){
        ivAdd.setOnClickListener(this);
        ivRemove.setOnClickListener(this);
    }

    private void setUpObservers(){
        viewModel.getCount().observe(this, changeCountObserver);
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.iv_add:
                viewModel.add();
            break;

            case R.id.iv_remove:
                viewModel.remove();
            break;
        }
    }
}
