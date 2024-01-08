package com.example.recyclerviewth3;



import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "Presidents App";
    Button btn_addOne;
    Menu menu;
    MyApplication myApplication;
    List<President> presidentList;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private  RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("MainActivity", "onCreate called");
        myApplication = (MyApplication) getApplication();
        presidentList = myApplication.getPresidentList();
        Log.d(TAG,"onCreate: "+ presidentList.toString());
        Log.d(TAG, "Presidents cont: " + presidentList.size());
        Toast.makeText(this, "Presidents cont: "+ presidentList.size(), Toast.LENGTH_SHORT).show();
        btn_addOne = (Button) findViewById(R.id.btn_addOne);

        btn_addOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,AddEditOne.class);
                startActivity(intent);
            }
        });
        recyclerView = findViewById(R.id.lv_presidentList);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        mAdapter = new RecyclerViewAdapter(presidentList, MainActivity.this);
        recyclerView.setAdapter(mAdapter);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.sort_menu,menu);
        return true;
    }

    @Override
    public  boolean onOptionsItemSelected(@NonNull MenuItem item){

        if (item.getItemId() == R.id.menu_aToz){
            Collections.sort(presidentList,President.PresidentNameAZComparator);
            Toast.makeText(MainActivity.this,"Sort A to Z",Toast.LENGTH_LONG).show();
            mAdapter.notifyDataSetChanged();
                return true;
        }
        if (item.getItemId() == R.id.menu_zToa){
            Collections.sort(presidentList,President.PresidentNameZAComparator);
            Toast.makeText(MainActivity.this,"Sort Z to A",Toast.LENGTH_LONG).show();
            mAdapter.notifyDataSetChanged();
            return true;
        }
        if (item.getItemId() == R.id.menu_dataAsc){
            Collections.sort(presidentList,President.PresidentDateAscComparator);
            Toast.makeText(MainActivity.this,"Sort date asc",Toast.LENGTH_LONG).show();
            mAdapter.notifyDataSetChanged();
            return true;
        }
        if (item.getItemId() == R.id.menu_dateDesc){
            Collections.sort(presidentList,President.PresidentDateDescComparator);
            Toast.makeText(MainActivity.this,"Sort date Desc",Toast.LENGTH_LONG).show();
            mAdapter.notifyDataSetChanged();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}