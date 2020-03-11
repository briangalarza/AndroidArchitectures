package com.briangalarza.androidarchitectures.model;

import java.util.List;

import io.reactivex.Single;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class CountriesService {

    //Url base
    public static final String BASE_URL = "https://restcountries.eu/rest/v2/";

    //Interface con el metodo para obtener todos los paises
    private CountriesApi api;

    /**
     * Metodo donde creamos una instancia de retrofit para ser utilizada
     * Utilizando tanto Gson como RxJava2
     */
    public CountriesService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        api = retrofit.create(CountriesApi.class);
    }

    //Retorna la interface con la información
    public Single<List<Country>> getCountries(){
        return api.getCountries();
    }
}
