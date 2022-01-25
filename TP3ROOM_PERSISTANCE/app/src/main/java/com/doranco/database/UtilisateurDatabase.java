package com.doranco.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.doranco.dao.UtilisateurDao;
import com.doranco.models.Utilisateur;

@Database(entities = {Utilisateur.class}, version = 1)
public abstract class UtilisateurDatabase extends RoomDatabase {

    private static String DATABASE = "formation";
    private static UtilisateurDatabase utilisateurDatabase;

    public static UtilisateurDatabase getInstance(Context context){
        if(utilisateurDatabase == null){
            utilisateurDatabase = Room.databaseBuilder(
                    context.getApplicationContext(),
                    UtilisateurDatabase.class,
                    DATABASE
            ).allowMainThreadQueries().build();
        }
        return utilisateurDatabase;
    }

    public abstract UtilisateurDao utilisateurDao();
}



