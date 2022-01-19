package com.doranco.android_tp3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        btn = findViewById(R.id.button2);
    }

    public void clickButton(View view){
        Log.i("Click button","Je viens de faire un click");
    }
    private void recuperationTexte(){
        String texte = editText.getText().toString();
        Log.i("Click Button", texte);
    }
}