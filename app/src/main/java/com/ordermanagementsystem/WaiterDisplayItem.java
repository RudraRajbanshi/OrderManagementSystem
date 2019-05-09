package com.ordermanagementsystem;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import helper.MyHelper;

public class WaiterDisplayItem extends AppCompatActivity {
    private ListView lstItems;
    private ImageView imgAdd,refresh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_waiter_display_item);

        lstItems = findViewById(R.id.lstItems);
        refresh = findViewById(R.id.refresh);
        refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WaiterDisplayItem.this,WaiterDisplayItem.class);
                startActivity(intent);
            }
        });
        imgAdd = findViewById(R.id.imgAdd);
        imgAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WaiterDisplayItem.this,WaiterAddItem.class);
                startActivity(intent);
            }
        });
        loadItem();
    }
    private void loadItem(){
        final MyHelper myHelper = new MyHelper(this);
        final SQLiteDatabase sqLiteDatabase = myHelper.getWritableDatabase();

        List<Items> itemsList = new ArrayList<>();
        itemsList = myHelper.GetAllWaiterItems(sqLiteDatabase);

        HashMap<Integer,String> hashMap = new HashMap<>();
        for (int i=0;i<itemsList.size();i++){
            hashMap.put(itemsList.get(i).getId(),itemsList.get(i).getItemName());
        }
        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<>(
                this,android.R.layout.simple_list_item_1,new ArrayList<String>(hashMap.values())
        );
        lstItems.setAdapter(stringArrayAdapter);
    }
}
