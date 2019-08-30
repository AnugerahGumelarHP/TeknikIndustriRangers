package com.battistradadeveloper.teknikindustrirangers;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.battistradadeveloper.teknikindustrirangers.Fragment.MainFragment.Account;
import com.battistradadeveloper.teknikindustrirangers.Fragment.MainFragment.Chat;
import com.battistradadeveloper.teknikindustrirangers.Fragment.MainFragment.Friend;
import com.battistradadeveloper.teknikindustrirangers.Fragment.MainFragment.More;
import com.battistradadeveloper.teknikindustrirangers.Fragment.MainFragment.Timeline;
import com.battistradadeveloper.teknikindustrirangers.FrontApp.Login;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAuth = FirebaseAuth.getInstance();
        if (mAuth.getCurrentUser() == null){
            finish();
            startActivity(new Intent(MainActivity.this, Login.class));
        } else {
            // kita set default nya Home Fragment
            loadFragment(new Friend());
            // inisialisasi BottomNavigaionView
            BottomNavigationView bottomNavigationView = findViewById(R.id.bn_main);
            // beri listener pada saat item/menu bottomnavigation terpilih
            bottomNavigationView.setOnNavigationItemSelectedListener(this);
        }
    }

    private boolean loadFragment(Fragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fl_container, fragment)
                    .commit();
            return true;
        }
        return false;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        Fragment fragment = null;
        switch (menuItem.getItemId()){
            case R.id.friend_menu:
                fragment = new Friend();
                break;
            case R.id.chat_menu:
                fragment = new Chat();
                break;
            case R.id.timeline_menu:
                fragment = new Timeline();
                break;
            case R.id.account_menu:
                fragment = new Account();
                break;
            case R.id.more_menu:
                fragment = new More();
                break;
        }
        return loadFragment(fragment);
    }
}
