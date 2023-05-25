package com.uniq_lab1.authentification;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainNavigation extends AppCompatActivity {
    private Fragment home_fragment = null;
    private Fragment notification_fragment = null;
    private Fragment setting_fragment = null;
    private Fragment selected_fragment = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_navigation);
        Intent data = getIntent();
        String first_name = data.getStringExtra("first_name");
        home_fragment = new HomeFragment(first_name);
        notification_fragment = new NotificationFragment();
        setting_fragment = new SettingFragment();

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation_view);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, home_fragment).commit();

        bottomNavigationView.setOnItemSelectedListener(item -> {

            if (item.getItemId() == R.id.home_icon) {
                selected_fragment = home_fragment;
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, selected_fragment).commit();
                return true;
            } else if (item.getItemId() == R.id.notification_icon) {
                selected_fragment = notification_fragment;
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, selected_fragment).commit();
                return true;
            } else if (item.getItemId() == R.id.setting_icon) {
                selected_fragment = setting_fragment;
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, selected_fragment).commit();
                return true;
            }

            return false;
        });
    }
}