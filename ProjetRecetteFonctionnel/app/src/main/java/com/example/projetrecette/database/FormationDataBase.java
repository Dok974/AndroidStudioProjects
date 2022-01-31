package com.example.projetrecette.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.projetrecette.dao.RecetteDao;
import com.example.projetrecette.dao.UtilisateurDao;
import com.example.projetrecette.entities.Recette;
import com.example.projetrecette.entities.Utilisateur;

@Database(entities = {Utilisateur.class, Recette.class}, version = 4)
public abstract class FormationDataBase extends RoomDatabase {
    private static final String DATABASE = "formation";
    private static FormationDataBase formationDataBase;

    public static FormationDataBase getInstance(Context context) {
        if (formationDataBase == null) {
            formationDataBase = Room.databaseBuilder(
                    context.getApplicationContext(),
                    FormationDataBase.class,
                    DATABASE
            ).allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return formationDataBase;
    }

    public abstract UtilisateurDao utilisateurDao();
    public abstract RecetteDao recetteDao();


}