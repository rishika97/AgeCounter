package com.example.agecounter;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class reg extends AppCompatActivity {
    DatabaseHelper db;
    EditText eno,ename,email,password;
    Button insert,view;
    TextView show;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);
        getSupportActionBar().setTitle("Register");
        db=new DatabaseHelper(this);
        eno=(EditText)findViewById(R.id.eno);
        password=(EditText)findViewById(R.id.password);
        email=(EditText)findViewById(R.id.email);
        ename=(EditText)findViewById(R.id.ename);
        insert=(Button)findViewById(R.id.insert);

        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ename.length() == 0 || email.length() == 0 || eno.getText().length() == 0 || password.length() == 0)
                    Toast.makeText(reg.this, "Please enter all values", Toast.LENGTH_SHORT).show();
                else {
                    // String data[]={eno.getText().toString(),ename.getText().toString()};
                    String data[] = new String[4];
                    data[0] = ename.getText().toString().trim();
                    data[1] = email.getText().toString().trim();
                    data[2] = eno.getText().toString().trim();
                    data[3] = password.getText().toString().trim();
                    if (db.insertData(data)) {
                        Toast.makeText(reg.this, "Data Inserted", Toast.LENGTH_SHORT).show();
                        ename.setText("");
                        email.setText("");
                        eno.setText("");
                        password.setText("");
                    }
                    else {
                        Toast.makeText(reg.this, "Failed to insert", Toast.LENGTH_SHORT).show();
                        ename.setText("");
                        email.setText("");
                        eno.setText("");
                        password.setText("");
                    }
                }
            }
        });
    }
}
