package com.doranco.api.interfaces;

import com.doranco.entites.ModelPerso;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiModelPerso {

    @GET("v3/90fea295-8b4d-4e7c-be1e-f0788188102f")
    Call<ModelPerso> getModelPerso();

}
