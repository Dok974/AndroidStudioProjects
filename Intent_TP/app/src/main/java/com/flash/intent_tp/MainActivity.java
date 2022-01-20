package com.flash.intent_tp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText valeurEuro;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Initialisation des variables
        valeurEuro=(EditText) findViewById(R.id.valeurEUR);
        Button button = findViewById(R.id.button);


        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity2.class);
                //Ajout de données dans un intent
                intent.putExtra("resultat", convertEurotoUsd());
                startActivity(intent);

            }
        });
    }
    /**
     *
     * @return
     */
    private String convertEurotoUsd(){
        //Recupération de la valeur en Euro
        double valeurEur = Double.parseDouble(valeurEuro.getText().toString());
        //Converstion de cette valeur en USD
        double valeurUsd = valeurEur * 1.14;
//        Log.i("Convert Btn click", String.valueOf(valeurUsd));
        String valeurUsdF = String.valueOf(valeurUsd);
        return valeurUsdF;
    }
}