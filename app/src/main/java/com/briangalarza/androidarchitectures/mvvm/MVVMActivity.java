package com.briangalarza.androidarchitectures.mvvm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.briangalarza.androidarchitectures.R;

public class MVVMActivity extends AppCompatActivity {

    private final String MVVM_TITLE = "MVVM Activity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvvm);
        setTitle(MVVM_TITLE);
    }


    /**
     *
     * @param context
     * @return intent
     */
    public static Intent getIntent(Context context){
        return new Intent(context,MVVMActivity.class);
    }

}
