package com.doranco.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.doranco.models.Utilisateur;

import java.util.List;

@Dao
public interface UtilisateurDao {

    @Query("SELECT * FROM Utilisateur")
    List<Utilisateur> getAllUtilisateurs();

    @Insert
    void createUtilisateur(Utilisateur utilisateur);


}
