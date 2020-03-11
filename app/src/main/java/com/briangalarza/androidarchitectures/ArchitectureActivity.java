package com.briangalarza.androidarchitectures;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.briangalarza.androidarchitectures.mvc.MVCActivity;
import com.briangalarza.androidarchitectures.mvp.MVPActivity;
import com.briangalarza.androidarchitectures.mvvm.MVVMActivity;

public class ArchitectureActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_architectures);
    }

    public void onMVC (View view){
        startActivity(MVCActivity.getIntent(this));
    }

    public void onMVP (View view){
        startActivity(MVPActivity.getIntent(this));
    }


    public void onMVVM (View view){
        startActivity(MVVMActivity.getIntent(this));
    }


}
