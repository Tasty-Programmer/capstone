package com.obyte.alcohol;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.obyte.alcohol.fragment.home.HomeFragment;
import com.obyte.alcohol.fragment.menu.MenuFragment;
import com.obyte.alcohol.fragment.search.SearchFragment;
import com.obyte.alcohol.fragment.shop.ShopFragment;

public class MainActivity extends AppCompatActivity {
    HomeFragment homeFragment;
    MenuFragment menuFragment;
    SearchFragment searchFragment;
    ShopFragment shopFragment;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        getSupportFragmentManager().beginTransaction().replace(R.id.container, homeFragment).commit();
        BottomNavigationView bottom_menu = findViewById(R.id.bottom_menu);
        bottom_menu.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
                                                  @Override
                                                  public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                                                      switch (item.getItemId()) {
                                                          case R.id.first_tab:
                                                              getSupportFragmentManager().beginTransaction().replace(R.id.container, homeFragment).commit();
                                                              return true;
                                                          case R.id.second_tab:
                                                              getSupportFragmentManager().beginTransaction().replace(R.id.container, menuFragment).commit();
                                                              return true;
                                                          case R.id.third_tab:
                                                              getSupportFragmentManager().beginTransaction().replace(R.id.container, searchFragment).commit();
                                                              return true;
                                                          case R.id.fourth_tab:
                                                              getSupportFragmentManager().beginTransaction().replace(R.id.container, shopFragment).commit();
                                                              return true;
                                                      }
                                                      return false;
                                                  }
                                              }
        );

    }

    public void init() {
        homeFragment = new HomeFragment();
        menuFragment = new MenuFragment();
        searchFragment = new SearchFragment();
        shopFragment = new ShopFragment();
    }
}