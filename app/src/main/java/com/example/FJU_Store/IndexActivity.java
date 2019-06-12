package com.example.FJU_Store;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
//toast快顯文件

public class IndexActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private ImageView iv; //照片iv
    private CollapsingToolbarLayout collapsingToolbarLayout;
    private Toolbar toolbar;
    private Toolbar toolbar_2;
    CardView c1;

    public IndexActivity() {
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);


        //接登入者mail!!
        Intent toindex = getIntent();
        final String getmail = toindex.getStringExtra("userMail");
        //Log.v("user",getmail+"");

        //摺疊式Toolbar
        collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar_layout);
        iv = (ImageView) findViewById(R.id.iv);
        toolbar_2 = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(toolbar_2);
        toolbar_2.setNavigationIcon(R.mipmap.ic_launcher);//ic_drawer_home
        collapsingToolbarLayout.setTitle("輔大二手商城");
        collapsingToolbarLayout.setCollapsedTitleTextColor(Color.BLACK);
        collapsingToolbarLayout.setExpandedTitleColor(Color.BLACK);
        iv.setImageResource(R.drawable.iv);//iv

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "按此可進入個人主頁", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        DrawerLayout drawer = findViewById(R.id.drawer_layout);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        // 左側欄位 btn1
        findViewById(R.id.btn1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(IndexActivity.this, "您點選購物車", Toast.LENGTH_SHORT).show();
                onBackPressed();
            }
        });

        //左側欄位 btn2

        findViewById(R.id.btn2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //toast用法:
                //Toast.makeText(IndexActivity.this, "您點選訂單", Toast.LENGTH_SHORT).show();
                //onBackPressed();
                //.Snackbar用法:
                //Snackbar.make(view, "您是否選擇進入買家功能", Snackbar.LENGTH_LONG).setAction("Action", null).show();
                //snackbat+toast
                Snackbar.make(view, "您是否選擇進入買家功能", Snackbar.LENGTH_LONG) .setAction("確定", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(IndexActivity.this,"您已選擇買家功能",Toast.LENGTH_SHORT).show();
                    }
                }).show();
            }
        });



        //跳頁到books_index
        Button btn_toCatagory = findViewById(R.id.books_index);
        btn_toCatagory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent toCatagory = new Intent(IndexActivity.this,Catagory_Activity.class);
                startActivity(toCatagory);
            }
        });
        //系統功能暫時連到ErrorReportActivity
        Button btn_toErrorReport = findViewById(R.id.system_function);
        btn_toErrorReport.setOnClickListener(new View.OnClickListener() {
             public void onClick(View v){

                 Intent btn_toErrorReport = new Intent(IndexActivity.this,ErrorReportActivity.class);
                 startActivity(btn_toErrorReport);
             }
        });
        //洪湘涵使用 上架
        Button  upload = findViewById(R.id.btn3);
        upload.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){

                Intent upload = new Intent(IndexActivity.this,create_product_1.class);
                upload.putExtra("mail",getmail);
                startActivity(upload);
            }
        });

        //洪湘涵使用 評價
        Button  score = findViewById(R.id.score);
        score.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){

                Intent score = new Intent(IndexActivity.this,inquire_evaluation.class);
                startActivity(score);
            }
        });

        //使用 .OrderActivity
        Button  toOrder = findViewById(R.id.OwnPage);
        toOrder.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){

                Intent toOrder = new Intent(IndexActivity.this,OrderActivity.class);
                startActivity(toOrder);
            }
        });

    }

    @Override
    //點按後自動縮回
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.index, menu);
        //return true;
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.index, menu);

        MenuItem menuSearchItem = menu.findItem(R.id.app_bar_search);

        // Get the SearchView and set the searchable configuration
        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView = (SearchView) menuSearchItem.getActionView();

        // Assumes current activity is the searchable activity
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));

        // 這邊讓icon可以還原到搜尋的icon
        searchView.setIconifiedByDefault(true);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        //menu/index.xml影響該id
       if (id == R.id.app_bar_search) {
           Toast.makeText(IndexActivity.this, "您點選搜尋", Toast.LENGTH_SHORT).show();
           return true;
       }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_tools) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
