package com.example.projetrecette.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.projetrecette.entities.Utilisateur;

import java.util.List;

//Impératif
@Dao
public interface UtilisateurDao {

    //facilite la vie en indiquant quel requete SQL est voulue ici
    //NB : ici, l'annotation considere le tableName donné à l'entité, pas le nom de la classe
    @Query("SELECT * FROM utilisateurs")
    List<Utilisateur> getAllUtilisateurs();

    //Indique à Room qu'on veut faire la persistance en BD des données, ici
    @Insert
    void createUtilisateur(Utilisateur utilisateur);

    @Update
    void updateUtilisateur(Utilisateur utilisateur);

    @Query("UPDATE utilisateurs SET nom =:nom , prenom=:prenom WHERE id=:id")
    int updateUser(String nom,String prenom, int id);

    @Delete
    void deleteUtilisateur(Utilisateur utilisateur);

}
