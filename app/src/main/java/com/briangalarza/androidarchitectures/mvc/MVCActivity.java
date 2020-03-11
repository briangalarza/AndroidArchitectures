package com.briangalarza.androidarchitectures.mvc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.briangalarza.androidarchitectures.R;

import java.util.ArrayList;
import java.util.List;

public class MVCActivity extends AppCompatActivity {

    private final String MVC_TITLE = "MVC Activity";

    private List<String> listValues = new ArrayList<>();
    private ArrayAdapter<String> adapter;
    private ListView list;
    private CountriesController controller;
    private Button retryButton;
    private ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvc);
        setTitle(MVC_TITLE);

        controller = new CountriesController(this);
        retryButton = findViewById(R.id.btnRetry);
        progressBar = findViewById(R.id.progressBar);

        configListView();

    }

    private void configListView(){
        list = findViewById(R.id.list);
        adapter = new ArrayAdapter<>(this,R.layout.row_layout, R.id.tvList, listValues);

        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MVCActivity.this,"País seleccionado" + listValues.get(position), Toast.LENGTH_SHORT).show();
            }
        });
    }


    public void onRetry(View view){
        controller.onRefresh();
        showProgressBar();
    }


    public void onError(){
        Toast.makeText(this,getString(R.string.error_message),Toast.LENGTH_SHORT).show();
        showRetryButton();
    }



    public void setValues (List<String> values){
        listValues.clear();
        listValues.addAll(values);
        hideProgressBar();
        adapter.notifyDataSetChanged();
    }

    public void showRetryButton(){
        progressBar.setVisibility(View.GONE);
        retryButton.setVisibility(View.VISIBLE);
        list.setVisibility(View.GONE);
    }
    public void hideProgressBar(){
        progressBar.setVisibility(View.GONE);
        retryButton.setVisibility(View.GONE);
        list.setVisibility(View.VISIBLE);
    }

    public void showProgressBar(){
        progressBar.setVisibility(View.VISIBLE);
        retryButton.setVisibility(View.GONE);
        list.setVisibility(View.GONE);
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
