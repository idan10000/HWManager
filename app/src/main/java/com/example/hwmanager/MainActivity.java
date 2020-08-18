package com.example.hwmanager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.hwmanager.fragments.AllCoursesFragment;
import com.example.hwmanager.fragments.HomeFragment;
import com.example.hwmanager.fragments.MyCoursesFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView m_botNav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        m_botNav = findViewById(R.id.bottom_navigation);
        m_botNav.setOnNavigationItemSelectedListener(m_itemSelectedListener);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragmentHolder, new HomeFragment()).commit();
        }
    }

    /**
     * The on item selected listener for the {@link #m_botNav}, which defines what happens when an item is selected
     */
    private BottomNavigationView.OnNavigationItemSelectedListener m_itemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selectedFragment = null;

            switch (item.getItemId()) {
                case R.id.menu_home:
                    selectedFragment = new HomeFragment();
                    break;
                case R.id.menu_all_courses:
                    selectedFragment = new AllCoursesFragment();
                    break;
                case R.id.menu_my_courses:
                    selectedFragment = new MyCoursesFragment();
                    break;
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.fragmentHolder,selectedFragment).commit();
            return true;
        }
    };
}