package com.example.myapplicationrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerviewItemAdapter recyclerviewItemAdapter;
    private RecyclerView recyclerView;
    private List<Items> itemsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        itemsList = new ArrayList<>();
        recyclerView = (RecyclerView)findViewById(R.id.recycleView);

        recyclerviewItemAdapter = new RecyclerviewItemAdapter(itemsList);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(recyclerviewItemAdapter);

        recyclerviewItemAdapter.setOnItemClickListener(new ClickListener<Items>(){
            @Override
            public void onClick(View view, Items data, int position) {
                Toast.makeText(getApplicationContext(),"Position = "+position+"\n Item = "+data.getName(),Toast.LENGTH_SHORT).show();

            }
        });

        prepareItems();

    }

    private void prepareItems(){
        Items items = new Items("Sunday");
        itemsList.add(items);
        items = new Items("Monday");
        itemsList.add(items);
        items = new Items("Tuesday");
        itemsList.add(items);
        items = new Items("Wednesday");
        itemsList.add(items);
        items = new Items("Thursday");
        itemsList.add(items);
        items = new Items("Friday");
        itemsList.add(items);
        items = new Items("Saturday");
        itemsList.add(items);
    }
}