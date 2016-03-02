package com.tboys.expressdelivery.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.tboys.expressdelivery.entity.Delivery;
import com.tboys.expressdelivery.adapter.DeliveryAdapter;
import com.tboys.expressdelivery.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private Toolbar toolbar;
    private ActionBarDrawerToggle toggle;

    private NavigationView navigationView;

    private ListView listView;
    private DeliveryAdapter adapter;
    private List<Delivery> deliveries;

    private SearchView searchView;
    private TextView textView_query_delivery;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("sss", "Main");

        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        navigationView = (NavigationView) findViewById(R.id.navigationView);
        searchView = (SearchView) findViewById(R.id.searchView);
        textView_query_delivery = (TextView) findViewById(R.id.textView_query_delivery);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");

        listView = (ListView) findViewById(R.id.listView_delivery);
        deliveries = new ArrayList<>();
        deliveries.add(new Delivery("申通 3304734675643", "湖南长沙雨花分公司", null, "今天 01:41"));
        adapter = new DeliveryAdapter(this, deliveries);
        listView.setAdapter(adapter);
        setSupportActionBar(toolbar);

        searchView.setOnSearchClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView_query_delivery.setText("");
            }
        });

        searchView.setOnCloseListener(new SearchView.OnCloseListener() {
            @Override
            public boolean onClose() {
                textView_query_delivery.setText("查询快递");
                return false;
            }
        });

        /**
         * 创建把手 匿名内部类
         */
        toggle = new ActionBarDrawerToggle(
                this,
                drawerLayout,
                R.string.open_drawer, R.string.close_drawer) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                invalidateOptionsMenu();
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                invalidateOptionsMenu();
            }
        };

        //同步,让把手替代Home的图标
        toggle.syncState();
        drawerLayout.setDrawerListener(toggle);
        navigationView.setCheckedItem(R.id.nav_delivery_record);

        navigationView.getHeaderView(0).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, LoginActivity.class));
            }
        });
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                if (item.isChecked()) {
                    item.setChecked(true);
                }
                switch (item.getItemId()) {
                    case R.id.nav_delivery_record:
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.nav_delivery_query:
                        startActivity(new Intent(MainActivity.this, QueryDeliveryActivity.class));
                        break;
                    case R.id.nav_delivery_send:
                        startActivity(new Intent(MainActivity.this, SendDeliveryActivity.class));
                        break;
                    case R.id.nav_delivery_contact:
                        startActivity(new Intent(MainActivity.this, MyContactActivity.class));
                        break;
                    case R.id.nav_delivery_setting:
                        startActivity(new Intent(MainActivity.this, SettingActivity.class));
                        break;
                    case R.id.nav_delivery_law:

                        break;
                    default:
                        Intent intent = new Intent(Intent.ACTION_SEND);
                        intent.setType("text/plain");
                        intent.putExtra(Intent.EXTRA_SUBJECT, "推荐给 ");
                        intent.putExtra(Intent.EXTRA_TEXT, "I would like to share this with you...");
                        startActivity(Intent.createChooser(intent, getTitle()));
                        break;
                }
                return true;
            }
        });

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle("");

    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.menu_activity_mydelivery, menu);
//        return true;
//    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()) {
//            case R.id.action_delete_delivery:
//                break;
//        }
        if (toggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
