package br.com.hapvida.fluxo.activity;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import br.com.hapvida.fluxo.R;
import br.com.hapvida.fluxo.fragment.ctx1.Contexto1Frag;
import br.com.hapvida.fluxo.fragment.cts2.Contexto2Frag;
import br.com.hapvida.fluxo.fragment.ctx3.Contexto3Frag;

public class PrincipalAct extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    Toolbar toolbar;
    DrawerLayout drawerLayout;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        initComponentsUi();
    }

    private void initComponentsUi(){
        toolbar = (Toolbar) findViewById(R.id.custom_toolbar);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerlayout);
        navigationView = (NavigationView) findViewById(R.id.navigationview);

        setSupportActionBar(toolbar);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,R.string.open_drawer, R.string.close_drawer);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_toolbar, menu);
        return true;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        Fragment fragment = null;
        FragmentManager fragmentManager;

        switch (menuItem.getItemId()){
            case R.id.menu_contexto_1:
                fragment = new Contexto1Frag();
            break;
            case R.id.menu_contexto_2:
                fragment = new Contexto2Frag();
                break;
            case R.id.menu_contexto_3:
                fragment = new Contexto3Frag();
                break;
            case R.id.menu_sair:
                // Implements...
            break;
        }

        drawerLayout.closeDrawer(GravityCompat.START);

        if(fragment != null){
            fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.area_fragmento, fragment).commit();
        }

        return true;
    }

    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }else{
            super.onBackPressed();
        }
    }
}
