package com.briangalarza.androidarchitectures.mvc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.briangalarza.androidarchitectures.R;

public class MVCActivity extends AppCompatActivity {

    private final String MVC_TITLE = "MVC Activity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvc);
        setTitle(MVC_TITLE);
    }


    /**
     *
     * @param context
     * @return intent
     */
    public static Intent getIntent(Context context){
        return new Intent(context,MVCActivity.class);
    }
}
