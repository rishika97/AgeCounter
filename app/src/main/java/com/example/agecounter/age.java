package com.example.agecounter;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import org.joda.time.Period;
import org.joda.time.PeriodType;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class age extends AppCompatActivity{
    Button b1,b2,b3;
    TextView t2;
    DatePickerDialog.OnDateSetListener date1,date2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_age);
        getSupportActionBar().setTitle("Age Counter");

        b1=(Button)findViewById(R.id.b1);
        b2=(Button)findViewById(R.id.b2);
        b3=(Button)findViewById(R.id.b3);
        t2=(TextView) findViewById(R.id.t2);

        Calendar cal=Calendar.getInstance();
        final int year = cal.get(Calendar.YEAR);
        final int month = cal.get(Calendar.MONTH);
        final int day = cal.get(Calendar.DAY_OF_MONTH);

        SimpleDateFormat sal= new SimpleDateFormat("dd/MM/yy");
        String date = sal.format(Calendar.getInstance().getTime());
        b1.setText(date);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog d1 = new DatePickerDialog(age.this,android.R.style.Theme_Holo_Light_Dialog_MinWidth,date1,year,month,day);
                d1.getWindow().setBackgroundDrawable(new ColorDrawable(Color.WHITE));
                d1.show();
            }
        });
        date1 = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month=month+1;
                String date=day+"/"+month+"/"+year;
                b1.setText(date);
            }
        };
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog d2 = new DatePickerDialog(age.this,android.R.style.Theme_Holo_Light_Dialog_MinWidth,date2,year,month,day);
                d2.getWindow().setBackgroundDrawable(new ColorDrawable(Color.WHITE));
                d2.show();
            }
        });
        date2 = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month= month + 1;
                String date=day+"/"+month+"/"+year;
                b2.setText(date);
            }
        };
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sdate = b1.getText().toString();
                String edate = b2.getText().toString();
                SimpleDateFormat sal1 = new SimpleDateFormat("dd/MM/yyyy");
                try
                {
                    Date dd1 = sal1.parse(sdate);
                    Date dd2 = sal1.parse(edate);

                    long startDate = dd1.getTime();
                    long endDate = dd2.getTime();
                    if(startDate <= endDate)
                    {
                        Period p = new Period(startDate,endDate, PeriodType.yearMonthDay());
                        int years = p.getYears();
                        int months = p.getMonths();
                        int days = p.getDays();

                        t2.setText(years+" Years | "+months+" Months | "+days+" Days");
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(),"Birthday should not be greater than Today's date!!!",Toast.LENGTH_LONG).show();

                    }
                }catch (ParseException e)
                {
                    e.printStackTrace();
                }
            }
        });
    }
}
