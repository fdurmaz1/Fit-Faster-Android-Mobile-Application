package com.example.termproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener,View.OnClickListener {

    public DrawerLayout drawerLayout;
    public ActionBarDrawerToggle drawerToggle;
    public NavigationView navigationView;

    private CardView D1,D2,D3,D4,D5,D6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("");
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION, WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        //CARDVIEW
        D1=(CardView)findViewById(R.id.d1);
        D2=(CardView)findViewById(R.id.d2);
        D3=(CardView)findViewById(R.id.d3);
        D4=(CardView)findViewById(R.id.d4);
        D5=(CardView)findViewById(R.id.d5);
        D6=(CardView)findViewById(R.id.d6);
        //CARDVIEW
        D1.setOnClickListener((View.OnClickListener) this);
        D2.setOnClickListener((View.OnClickListener) this);
        D3.setOnClickListener((View.OnClickListener) this);
        D4.setOnClickListener((View.OnClickListener) this);
        D5.setOnClickListener((View.OnClickListener) this);
        D6.setOnClickListener((View.OnClickListener) this);

        drawerLayout = findViewById(R.id.my_drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.nav_open, R.string.nav_close);
        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        navigationView.setNavigationItemSelectedListener(this);

    }

    @Override
    public void onClick (View v){
        Intent i;
        switch (v.getId()){
            case R.id.d1:i=new Intent(this,d1.class);
            startActivity(i);
            break;

            case R.id.d2:i=new Intent(this,d2.class);
                startActivity(i);
                break;

            case R.id.d3:i=new Intent(this,d3.class);
                startActivity(i);
                break;

            case R.id.d4:i=new Intent(this,d4.class);
                startActivity(i);
                break;

            case R.id.d5:i=new Intent(this,d5.class);
                startActivity(i);
                break;

            case R.id.d6:i=new Intent(this,d6.class);
                startActivity(i);
                break;
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (drawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()) {
            case R.id.nav_home:
                Toast.makeText(MainActivity.this,"Home Selected",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this,MainActivity.class);
                startActivity(intent);
                break;

            case R.id.nav_bmi:
                Toast.makeText(getApplicationContext(),"BMI Calculator Selected",Toast.LENGTH_SHORT).show();
                replaceFragment(new BodyMassIndexFragment());
                break;
//
//            case R.id.nav_profile:
//                Toast.makeText(getApplicationContext(),"Profile Selected",Toast.LENGTH_SHORT).show();
//                replaceFragment(new ProfileFragment());
//                break;

            case R.id.nav_rateUs:
                Toast.makeText(getApplicationContext(),"Rate Us Selected",Toast.LENGTH_SHORT).show();
                replaceFragment(new RateUsFragment());
                break;

            case R.id.nav_logout:
                Toast.makeText(MainActivity.this,"Logout Selected",Toast.LENGTH_SHORT).show();
                intent = new Intent(MainActivity.this,LoginActivity.class);
                startActivity(intent);
                break;


        }

        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout,fragment);
        fragmentTransaction.commit();
    }

    @Override
    public void onBackPressed(){
        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }else {
            super.onBackPressed();
        }
    }

}