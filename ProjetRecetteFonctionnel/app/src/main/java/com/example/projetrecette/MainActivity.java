package com.example.projetrecette;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.projetrecette.fragments.HomeFragment;
import com.example.projetrecette.fragments.RecettesFragment;
import com.example.projetrecette.fragments.UtilisateursFragment;
import com.google.android.material.navigation.NavigationView;


public class MainActivity extends AppCompatActivity {

    //Initialisation des variables
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private Toolbar toolbar;
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Uberisation (une ligne pour faire tout le boulot caché)
        initComponents();

        //Cellule d'écoute de la NS..euh, non des items du navView
        onClickListenerNavigationViewItems();

        //Chargement du fragment par défaut
        loadDefaultFragment(savedInstanceState);




    }

    /**
     * Cette fonction permet d'initialiser les composants au démarrage
     * et de garder le onCreate le plus clair et propre possible
     */
    private void initComponents() {

        drawerLayout = findViewById(R.id.drawerLayout);
        navigationView = findViewById(R.id.navView);
        toolbar = findViewById(R.id.toolbar);
        fragmentManager = getSupportFragmentManager();

        setSupportActionBar(toolbar);

        //Création du bouton toggle
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,
                drawerLayout, toolbar, R.string.openDrawer, R.string.closeDrawer);

        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        //Initialisation du navigation drawer


    }

    /**
     * Méthode chargée de lancer, au démarrage, le fragment par défaut (le HomeFragment)
     * Bundle, classe géante qui gère les paquets et les échanges de données
     * (un peu comme le JSON ?)
     * savedInstanceState : valeur nulle au lancement, mais cette valeur change
     * par exemple, si on met l'appli en pause, ou en arrière-plan
     * Dans la méthode ci-dessous, on récupère cet état pour gérer l'affichage : si
     * rien, on affiche le fragment par défaut, sinon, on affiche l'état sauvegaré
     */
    private void loadDefaultFragment(Bundle savedInstanceState) {
        if (savedInstanceState == null) {
            loadAnyFragment(new HomeFragment(), 1);
        }
    }

    private void loadAnyFragment(Fragment fragment, int action) {
        //Vérif action à effectuer
        if (action == 1) {
            //1 = add()
            fragmentManager
                    .beginTransaction()
                    .add(R.id.frameLayout, fragment)
                    .commit();
        }
        if (action == 2) {
            //2 = replace
            fragmentManager
                    .beginTransaction()
                    .replace(R.id.frameLayout, fragment)
                    .commit();
        }
    }


    /**
     * Fonction qui permet d'écouter les clics sur les éléments du navigationView
     */
    private void onClickListenerNavigationViewItems() {

        //On fait appel à une des méthodes dédiées de navigationView
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                //Petite verif que tout fonctionne bien
                //Toast.makeText(getApplicationContext(), "Clic sur un élément du navView", Toast.LENGTH_LONG).show();
                //Si l'item du menu sélectionné ne change pas de couleur, utiliser le code ci-dessous
                //item.setChecked(true);

                //Au clic sur un item, le drawer se ferme
                //(ici, on utilise la méthode closeDrawers(), avec un "s"))
                drawerLayout.closeDrawers();

                //Récupération de l'id de chaque item
                int id = item.getItemId();
                //Si on veut afficher l'id de chaque item
                //Toast.makeText(getApplicationContext(), String.valueOf(id), Toast.LENGTH_SHORT).show();

                //TIP : pour indenter dans AS : ctrl + alt + l

                //Pour modifier l'affichage après chaque clic
                switch (id) {
                    case R.id.nav_menu_ma_cuisine:
                        toolbar.setTitle(R.string.ma_cuisine);
                        loadAnyFragment(new HomeFragment(),2);
                        break;
                    case R.id.nav_menu_utilisateurs:
                        toolbar.setTitle(R.string.users);
                        loadAnyFragment(new UtilisateursFragment(),2);
                        break;
                    case R.id.nav_menu_recettes:
                        toolbar.setTitle(R.string.recettes);
                        loadAnyFragment(new RecettesFragment(),2);
                        break;
                    case R.id.nav_menu_ingredients:
                        toolbar.setTitle(R.string.ingredients);
                        break;
                    case R.id.nav_menu_parametres:
                        toolbar.setTitle(R.string.parametres);
                        break;
                    case R.id.nav_menu_deconnexion:
                        toolbar.setTitle(R.string.deconnexion);
                        break;

                    default:
                        return true;

                }

                return true;
            }
        });
    }


    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}