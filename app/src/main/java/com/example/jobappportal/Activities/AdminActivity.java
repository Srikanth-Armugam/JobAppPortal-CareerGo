package com.example.jobappportal.Activities;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.example.jobappportal.Fragments.AddJobFragment;
import com.example.jobappportal.Fragments.AdminDashboardFragment;
import com.example.jobappportal.Fragments.AdminProfileFragment;
import com.example.jobappportal.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class AdminActivity extends AppCompatActivity {

    FrameLayout frameLayout;
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        //Assigning framelayout resource file to show appropriate fragment using address
        frameLayout = (FrameLayout) findViewById(R.id.AdminFragmentContainer);
        //Assigining Bottomnavigaiton Menu
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.AdminBottomNavigationView);
        Menu menuNav = bottomNavigationView.getMenu();
        //Setting the default fragment as HomeFragment
        getSupportFragmentManager().beginTransaction().replace(R.id.AdminFragmentContainer, new AddJobFragment()).commit();
        //Calling the bottoNavigationMethod when we click on any menu item
        bottomNavigationView.setOnNavigationItemSelectedListener(bottomNavigationMethod);
    }


    private BottomNavigationView.OnNavigationItemSelectedListener bottomNavigationMethod =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull @org.jetbrains.annotations.NotNull MenuItem item) {

                    //Assigining Fragment as Null
                    Fragment fragment = null;
                    int id=item.getItemId();
                        //Shows the Appropriate Fragment by using id as address
                        if(id==R.id.homeMenu) {
                           fragment= new AddJobFragment();
                        }
                       else if (id==R.id.Dashboard) {
                            fragment = new AdminDashboardFragment();
                        }
                        else if(id==R.id.profileMenu) {
                            fragment = new AdminProfileFragment();
                        }

                     getSupportFragmentManager().beginTransaction().replace(R.id.AdminFragmentContainer, fragment).commit();
                    return true;
                }
            };
}