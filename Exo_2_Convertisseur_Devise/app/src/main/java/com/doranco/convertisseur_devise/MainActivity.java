package com.doranco.convertisseur_devise;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

private Button convertBtn;
private EditText valeurEuro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Initialisation des variables
        valeurEuro=(EditText) findViewById(R.id.valeurEUR);
        convertBtn=(Button) findViewById(R.id.button);

        convertBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                convertEurotoUsd();
            }
        });
        convertBtn.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                convertEurotoUsdLongClick();
                return false;
            }
        });
    }
    /**
     *
     */
    private void convertEurotoUsd(){
        //Recupération de la valeur en Euro
        double valeurEur = Double.parseDouble(valeurEuro.getText().toString());
        //Converstion de cette valeur en USD
        double valeurUsd = valeurEur * 1.14;
        Toast.makeText(this, valeurEur + " EUR = " + valeurUsd + " USD",Toast.LENGTH_LONG).show();
//        Log.i("Convert Btn click", String.valueOf(valeurUsd));
    }
    private void convertEurotoUsdLongClick(){
        //Recupération de la valeur en Euro
        double valeurEur = Double.parseDouble(valeurEuro.getText().toString());
        //Converstion de cette valeur en USD
        double valeurUsd = valeurEur * 1.14;
        String texte = valeurEur + " EUR = " + valeurUsd + " USD";

        new AlertDialog.Builder(this)
                .setTitle("EUR to USD")
                .setMessage(texte)
                .setPositiveButton("oui",(dialogInterface, i) -> {
                    Log.i(" click", "User has click yes");
                })
                .setNegativeButton("non",(dialogInterface, i) -> {
                    Log.i(" click", "User has click no");
                })
                .show();
        //        Log.i("Convert Btn click", String.valueOf(valeurUsd));
    }
}