package com.ordermanagementsystem;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import helper.MyHelper;

public class AdminAddItemActivity extends AppCompatActivity {
    private EditText etItem;
    private Button btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_add_item);

        etItem = findViewById(R.id.etItem);
        btnAdd = findViewById(R.id.btnAdd);

        final MyHelper myHelper = new MyHelper(this);
        final SQLiteDatabase sqLiteDatabase = myHelper.getWritableDatabase();

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                long id = myHelper.insertData(etItem.getText().toString(),sqLiteDatabase);
                if (id>0){
                    Toast.makeText(AdminAddItemActivity.this,"Successful " +id,Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(AdminAddItemActivity.this,"Error ",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
