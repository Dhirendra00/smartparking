package com.example.finalyear;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.DateFormat;
import java.util.Calendar;


public class PreFourWheelDashboard extends AppCompatActivity {
    EditText editTextDate, editTextTime;
    Button btnConfirm, btnCancel;
    FirebaseDatabase root;
    DatabaseReference databaseReference;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pre_four_wheel);
        root= FirebaseDatabase.getInstance();
        databaseReference=root.getReference("parking");

        Calendar calendar = Calendar.getInstance();
        String currentDate= DateFormat.getDateInstance(DateFormat.FULL).format(calendar.getTime());
        editTextDate=(EditText) findViewById(R.id.editTextDate);
        editTextDate.setText(currentDate);


        editTextTime=(EditText) findViewById(R.id.editTextTime);
        editTextTime.setText("*Coupon Expire After 10:00AM");


        btnConfirm=(Button) findViewById(R.id.btnConfirm);
        btnCancel=(Button) findViewById(R.id.btnCancel);

        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),BookingDetail.class);
                startActivity(intent);
            }
        });


    }

}