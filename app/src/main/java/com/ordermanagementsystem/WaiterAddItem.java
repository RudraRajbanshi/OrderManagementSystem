package com.ordermanagementsystem;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import helper.MyHelper;

public class WaiterAddItem extends AppCompatActivity {
    private EditText etItem;
    private Button btnAdd;
    private Spinner spin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_waiter_add_item);

        etItem = findViewById(R.id.etItem);
        btnAdd = findViewById(R.id.btnAdd);
        spin = findViewById(R.id.spin);

        final MyHelper myHelper = new MyHelper(this);
        final SQLiteDatabase sqLiteDatabase = myHelper.getWritableDatabase();

        List<Items> itemsList = new ArrayList<>();
        itemsList = myHelper.GetAllItems(sqLiteDatabase);

        HashMap<Integer,String> hashMap = new HashMap<>();
        for (int i=0;i<itemsList.size();i++){
            hashMap.put(itemsList.get(i).getId(),itemsList.get(i).getItemName());
        }
        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<>(
                this,android.R.layout.simple_list_item_1,new ArrayList<String>(hashMap.values())
        );
        spin.setAdapter(stringArrayAdapter);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                long id = myHelper.insertWaiterData(spin.getSelectedItem().toString(),sqLiteDatabase);
                if (id>0){
                    Toast.makeText(WaiterAddItem.this,"Successful ",Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(WaiterAddItem.this,"Error ",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

}
