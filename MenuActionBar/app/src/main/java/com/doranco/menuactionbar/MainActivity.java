package com.doranco.menuactionbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.notre_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch(id){
            case R.id.itemMenu1:
                Toast.makeText(this, "le bouton search a ete clique", Toast.LENGTH_SHORT).show();
                Log.i("itemMenu1", "Search button clicked");
                return true;
            case R.id.itemMenu2:
                Toast.makeText(this, "le bouton NW a ete clique", Toast.LENGTH_SHORT).show();
                Log.i("itemMenu2", "new window button clicked");
                return true;
            case R.id.itemMenu3:
                Toast.makeText(this, "le bouton Sort by a ete clique", Toast.LENGTH_SHORT).show();
                Log.i("itemMenu3", "sort sort clicked");
                return true;
            case R.id.itemMenu4:
                Toast.makeText(this, "le bouton select all a ete clique", Toast.LENGTH_SHORT).show();
                Log.i("itemMenu4", "select button clicked");
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}