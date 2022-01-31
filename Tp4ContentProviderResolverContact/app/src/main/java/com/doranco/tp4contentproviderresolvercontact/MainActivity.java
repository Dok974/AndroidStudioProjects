package com.doranco.tp4contentproviderresolvercontact;

import androidx.annotation.ColorInt;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.net.URI;

public class MainActivity extends AppCompatActivity {
Button btnGetContacts;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnGetContacts = findViewById(R.id.buttonGetContacts);

        btnGetContacts.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                fetchContacts();
            }

        });
    }


    public void fetchContacts(){
        // verification de la permission
        if(ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.READ_CONTACTS)
        != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.READ_CONTACTS},
                    0);
        }else{
            ContentResolver contentResolver = getContentResolver();

            Uri uri = ContactsContract.CommonDataKinds.Phone.CONTENT_URI;

            Cursor cursor = null;
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                cursor = contentResolver.query(uri, null, null, null);
            }

            int nombreContacts = cursor.getCount();
            Log.v("Nombre contacts ", "Il y en a " + nombreContacts);

            int indexNom = cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME);
            int indexTelephone = cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER);

            cursor.moveToFirst();

            while (!cursor.isAfterLast()){

                Log.v("View Contacts ","{Nom : " + cursor.getString(indexNom)
                        + " Telephone : " + cursor.getString(indexTelephone) + " } ");
                cursor.moveToNext();
            }
            cursor.close();
        }
    }
}