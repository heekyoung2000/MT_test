package com.example.test1;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private FragmentManager fragmentManager = getSupportFragmentManager();
    private homeFragment fragmentHome = new homeFragment();
    private cameraFragment fragmentCamera = new cameraFragment();
    private calendarFragment fragmentCalendar = new calendarFragment();
    private searchFragment fragmentSearch = new searchFragment();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.frameLayout, fragmentSearch).commitAllowingStateLoss();

        BottomNavigationView bottomNavigationView = findViewById(R.id.navigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(new ItemSelectedListener());
    }

    class ItemSelectedListener implements BottomNavigationView.OnNavigationItemSelectedListener{
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            FragmentTransaction transaction = fragmentManager.beginTransaction();

            switch(menuItem.getItemId())
            {
                case R.id.homeItem:
                    Intent intent1 = new Intent(MainActivity.this, homeActivity.class);
                    startActivity(intent1);
                    //transaction.replace(R.id.frameLayout, fragmentHome).commitAllowingStateLoss();
                    break;

                case R.id.cameraItem:
                    Intent intent2 = new Intent(MainActivity.this, cameraActivity.class);
                    startActivity(intent2);
                    //transaction.replace(R.id.frameLayout, fragmentCamera).commitAllowingStateLoss();

                    break;

                    case R.id.calendarItem:
                        Intent intent3 = new Intent(MainActivity.this, calendarActivity.class);
                        startActivity(intent3);
                        //transaction.replace(R.id.frameLayout, fragmentCalendar).commitAllowingStateLoss();
                        break;

                    case R.id.searchItem:
                        /*Intent intent4 = new Intent(MainActivity.this, searchActivity.class);
                        startActivity(intent4);*/
                        transaction.replace(R.id.frameLayout, fragmentSearch).commitAllowingStateLoss();
                        break;
            }
            return true;
        }

    }
}