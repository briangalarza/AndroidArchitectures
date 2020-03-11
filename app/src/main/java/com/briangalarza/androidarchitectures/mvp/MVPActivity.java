package com.briangalarza.androidarchitectures.mvp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.briangalarza.androidarchitectures.R;

public class MVPActivity extends AppCompatActivity {

    private final String MVP_TITLE = "MVP Activity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvp);

        setTitle(MVP_TITLE);
    }


    /**
     *
     * @param context
     * @return intent
     */
    public static Intent getIntent(Context context){
        return new Intent(context,MVPActivity.class);
    }

}
