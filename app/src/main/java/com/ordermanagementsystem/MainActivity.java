package com.ordermanagementsystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText etUsername,etPassword;
    private Button btnLogin;
    private Spinner spin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        spin = findViewById(R.id.spin);
        btnLogin = findViewById(R.id.btnLogin);

        String user[] ={"choose","admin","waiter"};
        ArrayAdapter<String> adapter =new ArrayAdapter<String >(this,android.R.layout.simple_list_item_1,user);
        spin.setAdapter(adapter);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (spin.getSelectedItem().equals("choose")){
                    Toast.makeText(MainActivity.this,"please choose user type",Toast.LENGTH_LONG).show();
                }
                else if (spin.getSelectedItem().equals("admin")){
                    if (etUsername.getText().toString().equals("admin") && etPassword.getText().toString().equals("admin")){
                        Toast.makeText(MainActivity.this,"Login successful",Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(MainActivity.this,AdminDisplayItemActivity.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(MainActivity.this,"Invalid username/password",Toast.LENGTH_LONG).show();
                    }
                }else if (spin.getSelectedItem().equals("waiter")){
                    if (etUsername.getText().toString().equals("waiter") && etPassword.getText().toString().equals("waiter")){
                        Toast.makeText(MainActivity.this,"Login successful",Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(MainActivity.this,WaiterDisplayItem.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(MainActivity.this,"Invalid username/password",Toast.LENGTH_LONG).show();
                    }
                }

            }
        });


    }
}
