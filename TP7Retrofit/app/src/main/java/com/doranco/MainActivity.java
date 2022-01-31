package com.doranco;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.doranco.api.interfaces.ApiModelPerso;
import com.doranco.entites.ModelPerso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private void fetchModelPersoData(){
        //Creation de l'objet retrofit
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://run.mocky.io/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        //Create instance de notre interface
        ApiModelPerso apiModelPerso = retrofit.create(ApiModelPerso.class);

        Call<ModelPerso> call = apiModelPerso.getModelPerso();

        //Execution et Traitement de la requête
        call.enqueue(new Callback<ModelPerso>() {
            @Override
            public void onResponse(Call<ModelPerso> call, Response<ModelPerso> response) {
                if(response.code() != 200){
                    Log.v("apiCall", "un problem");
                    return;
                }

                ModelPerso modelPerso = response.body();
                Log.v("apiCall ", String.valueOf(response));
            }

            @Override
            public void onFailure(Call<ModelPerso> call, Throwable t) {
                Log.v("apiCall error", String.valueOf(t));
            }
        });
    }
}