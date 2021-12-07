package com.example.flexlite;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;

public class DropCourseActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ImageView menuIcon;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drop_course);

        drawerLayout = (DrawerLayout) findViewById(R.id.drop_drawer);
        navigationView = (NavigationView) findViewById(R.id.stud_nav);
        menuIcon = (ImageView) findViewById(R.id.stud_menu_icon);


        View headerView = navigationView.getHeaderView(0);
        TextView navUsername = (TextView) headerView.findViewById(R.id.header_user_name);
        TextView navEmail = (TextView) headerView.findViewById(R.id.header_email);
        navUsername.setText("Haseeb Shams");
        navEmail.setText("hadishams38.hs@gmail.com");

        navigationDrawer();
    }
    private void navigationDrawer() {
        navigationView.bringToFront();
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.nav_drop);

        menuIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (drawerLayout.isDrawerVisible(GravityCompat.START)) {
                    drawerLayout.closeDrawer(GravityCompat.START);
                } else {
                    drawerLayout.openDrawer(GravityCompat.START);
                }
            }
        });

        TableLayout table = (TableLayout) DropCourseActivity.this.findViewById(R.id.dropTable);

        // Inflate your row "template" and fill out the fields.
        TableRow row = (TableRow) LayoutInflater.from(DropCourseActivity.this).inflate(R.layout.drop_table_row, null);
        ((TextView) row.findViewById(R.id.courseName)).setText("Software Mobile Development");
        TextView btn = (TextView)row.findViewById(R.id.drop_btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                table.removeView(row);
            }
        });
        table.addView(row);


        table.requestLayout();

    }

    @Override
    protected void onResume() {
        super.onResume();
        navigationView.setCheckedItem(R.id.nav_drop);
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerVisible(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_reg:
                drawerLayout.closeDrawers();
                Intent intent2 = new Intent(DropCourseActivity.this,RegistrationActivity.class);
                startActivity(intent2);
                break;
            case R.id.nav_stud_home:
                drawerLayout.closeDrawers();
                Intent intent = new Intent(DropCourseActivity.this,StudentHomeActivity.class);
                startActivity(intent);
                break;
            case R.id.nav_drop:
                drawerLayout.closeDrawers();
                break;
//            case R.id.nav_logout:
//                finish();
//                break;
        }
        return true;
    }
}