package com.example.projetrecette.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.projetrecette.entities.Recette;

import java.util.List;

@Dao
public interface RecetteDao {

    @Query("SELECT * FROM Recette")
    List<Recette> getAllRecettes();

    @Insert
    void createRecette(Recette recette);

    @Delete
    void deleteRecette(Recette recette);
}
