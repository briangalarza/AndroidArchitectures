package com.briangalarza.androidarchitectures.mvc;

import android.annotation.SuppressLint;

import com.briangalarza.androidarchitectures.model.CountriesService;
import com.briangalarza.androidarchitectures.model.Country;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class CountriesController {

    private MVCActivity view;

    private CountriesService service;


    public CountriesController(MVCActivity view){
        this.view = view;
        service = new CountriesService();
        fetchCountries();
    }


    @SuppressLint("CheckResult")
    private void fetchCountries(){
        service.getCountries()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSingleObserver<List<Country>>() {

                    @Override
                    public void onSuccess(List<Country> value) {
                        List<String> countryNames = new ArrayList<>();
                        for (Country country : value){
                            countryNames.add(country.countryName);
                        }
                        view.setValues(countryNames);
                    }

                    @Override
                    public void onError(Throwable e) {
                        view.onError();
                    }
                });
    }


    public void onRefresh(){
        fetchCountries();
    }

}
