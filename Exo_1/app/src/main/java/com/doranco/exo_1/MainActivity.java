package com.doranco.exo_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
private EditText editText, editText2;
private Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText=(EditText)findViewById(R.id.editlogin);
        editText2=(EditText)findViewById(R.id.editPassword);
        btn=(Button) findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                recuperationTexte();
            }
        });
    }

    private void recuperationTexte() {
        String texte = editText.getText().toString();
        String texte2 = editText2.getText().toString();
        Log.i("Click Button", texte + " " + texte2);
    }
}