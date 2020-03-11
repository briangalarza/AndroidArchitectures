package com.briangalarza.androidarchitectures.model;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;

public interface CountriesApi {
    //Endpoint para obtener el listado completo con toda la información
    @GET("all")
    Single<List<Country>> getCountries();

}
