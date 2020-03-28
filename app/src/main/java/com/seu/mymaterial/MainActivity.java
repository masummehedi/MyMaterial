package com.seu.mymaterial;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;

    NavigationView navigationView;

    BottomNavigationView bottomNavigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        drawerLayout = findViewById(R.id.drawer);
        navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.upload_d:
                        // Toast.makeText(MainActivity.this, "Drawer Upload Clicked", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), Activity_2.class);


                        startActivity(intent);

                        break;
                    case R.id.share_d:
                        Toast.makeText(MainActivity.this, "Drawer share Clicked", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.send_d:
                        Toast.makeText(MainActivity.this, "Drawer send Clicked", Toast.LENGTH_SHORT).show();
                        break;


                }
                drawerLayout.closeDrawer(GravityCompat.START);

                return true;
            }
        });


        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle
                (MainActivity.this, drawerLayout, toolbar,
                        R.string.nav_open, R.string.nav_close);

        drawerLayout.addDrawerListener(toggle);

        toggle.syncState();

        bottomNavigationView = findViewById(R.id.bottom_nav);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){
                    case R.id.upload_b:

                        Toast.makeText(MainActivity.this, " Navigation upload", Toast.LENGTH_SHORT).show();

                        break;

                    case R.id.share_b:

                        Toast.makeText(MainActivity.this, " Navigation Share", Toast.LENGTH_SHORT).show();

                        break;
                    case R.id.send_b:

                        Toast.makeText(MainActivity.this, " Navigation Send", Toast.LENGTH_SHORT).show();

                        break;

                }


                return true;
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {

            case R.id.upload:

                Toast.makeText(getApplicationContext(), "Uplaod Clicked", Toast.LENGTH_LONG).show();

                return true;

            case R.id.share:

                Toast.makeText(getApplicationContext(), "Share Clicked", Toast.LENGTH_LONG).show();

                return true;

            case R.id.send:

                Toast.makeText(getApplicationContext(), "Send Clicked", Toast.LENGTH_LONG).show();

                return true;


            default:
                return super.onOptionsItemSelected(item);


        }


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
