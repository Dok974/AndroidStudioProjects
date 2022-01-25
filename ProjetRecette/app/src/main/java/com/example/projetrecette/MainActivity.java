package com.example.projetrecette;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.projetrecette.fragments.HomeFragment;
import com.example.projetrecette.fragments.UtilisateursFragment;
import com.google.android.material.navigation.NavigationView;


public class MainActivity extends AppCompatActivity {
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private Toolbar toolbar;
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initComponents();
        loadDefaultFragment(savedInstanceState);
        onClickListenNavigationViewItems();

    }

    /**
     * Cette fonction permet d'initialiser les composents de notre application
     */
    private void initComponents() {

        drawerLayout = findViewById(R.id.drawerLayout);
        navigationView = findViewById(R.id.navView);
        toolbar = findViewById(R.id.toolbar);
        fragmentManager = getSupportFragmentManager();

        setSupportActionBar(toolbar);
        // Creation du bouton toggle
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,
                drawerLayout, toolbar, R.string.openDrawer, R.string.closeDrawer);

        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

    }

    /**
     * Cette function ajoute le fragment par defaut a notre FrameLayout du activity_main
     * @param savedInstanceState
     */
    private void loadDefaultFragment(Bundle savedInstanceState){
        if (savedInstanceState == null){
            loadAnyFragment(new HomeFragment(),1);
        }
    }
    private void loadAnyFragment(Fragment fragment, int action){
        // Check action a effectuer
        if (action == 1){
            // Action ici est un add
            fragmentManager
                    .beginTransaction()
                    .add(R.id.frameLayout, fragment)
                    .commit();
        }
        if (action == 2){
            // ACtion ici est un replace
            fragmentManager
                    .beginTransaction()
                    .replace(R.id.frameLayout, fragment)
                    .commit();
        }
    }
    /**
     * Cette funtion permet de'effectuer des ecoutes de click sur le navigation view
     */
    private void onClickListenNavigationViewItems() {

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                drawerLayout.closeDrawers();
                int id = item.getItemId();
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