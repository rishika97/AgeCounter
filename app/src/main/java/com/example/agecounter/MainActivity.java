package com.example.agecounter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    DatabaseHelper db;
    String n,p;
    int j=0;
    Button login;
    EditText e1,e2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("Login");
        db = new DatabaseHelper(this);
        login=(Button)findViewById(R.id.log);
        e1=(EditText) findViewById(R.id.e1);
        e2=(EditText) findViewById(R.id.e2);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                n=e1.getText().toString();
                p=e2.getText().toString();
                if (n.isEmpty() || p.isEmpty())
                {
                    Toast.makeText(MainActivity.this,"Enter all the detais",Toast.LENGTH_LONG).show();
                }
                else
                {
                    String uname=e1.getText().toString();
                    String passw=e2.getText().toString();
                    if (db.getData(uname,passw))
                    {
                        String data=n;
                        Intent i=new Intent(MainActivity.this,age.class);
                        i.putExtra("data",data);
                        startActivity(i);
                    }
                    else
                    {
                        Toast.makeText(MainActivity.this,"Incorrect Username or Password",Toast.LENGTH_LONG).show();
                    }
                }
            }
        });

    }


    public  void subete(View v){
        startActivity(new Intent(MainActivity.this,age.class));
    }
    public  void gotoreg(View v){
        startActivity(new Intent(MainActivity.this,reg.class));
    }
}

