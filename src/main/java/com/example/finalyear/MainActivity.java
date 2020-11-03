package com.example.finalyear;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.graphics.Color;
import android.media.Image;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.DateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    EditText editTextUsername, editTextContactNumber, editTextVehicleModel,editTextVehicleNumber;
    Button btnRegister;
    FirebaseDatabase root;
    DatabaseReference databaseReference;
    GridLayout mainGrid;
    String vehicle_type;
    CardView two_wheel,four_wheel;
    int finalI = 0;
    ImageView user;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        root=FirebaseDatabase.getInstance();
        databaseReference= root.getReference("parking");


        editTextUsername= (EditText) findViewById(R.id.editTextUsername);
        editTextContactNumber= (EditText) findViewById(R.id.editTextContactNumber);
        editTextVehicleModel= (EditText) findViewById(R.id.editTextVehicleModel);
        editTextVehicleNumber= (EditText) findViewById(R.id.editTextVehicleNumber);
        btnRegister=(Button) findViewById(R.id.btnRegister);
        mainGrid =(GridLayout) findViewById(R.id.mainGrid);

        two_wheel= (CardView) findViewById(R.id.two_wheel);
        four_wheel= (CardView) findViewById(R.id.four_wheel);

        user=findViewById(R.id.user);

//       adding click listener

        two_wheel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finalI=0;
                Toast.makeText(MainActivity.this,"bike" +finalI,Toast.LENGTH_SHORT).show();
                two_wheel.setCardBackgroundColor(Color.parseColor("#009688"));
                four_wheel.setCardBackgroundColor(Color.parseColor("#ffffff"));
            }
        });
        four_wheel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finalI=1;
                Toast.makeText(MainActivity.this,"car"+finalI,Toast.LENGTH_SHORT).show();
                four_wheel.setCardBackgroundColor(Color.parseColor("#009688"));
                two_wheel.setCardBackgroundColor(Color.parseColor("#ffffff"));
            }
        });

        user.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(i);
            }
        } );

//        click listener
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                confirmBooking();

            }
        });
    }



    public void confirmBooking(){
        String username=editTextUsername.getText().toString().trim();
        String contact_number=editTextContactNumber.getText().toString().trim();
        String vehicle_model=editTextVehicleModel.getText().toString().trim();
        String vehicle_number=editTextVehicleNumber.getText().toString().trim();
        Calendar calendar =Calendar.getInstance();
        String date= DateFormat.getDateInstance(DateFormat.FULL).format(calendar.getTime());
        String time="null";
        if(!TextUtils.isEmpty(username)){
            String id =databaseReference.push().getKey();
            if (finalI==0) {
                String vehicle = "Bike";


                BookingHelper bookingHelper = new BookingHelper(vehicle, username, contact_number, vehicle_model, vehicle_number, date, time);

                databaseReference.child(contact_number).setValue(bookingHelper);

                Toast.makeText(this, "added", Toast.LENGTH_LONG).show();
                Intent intent=new Intent(getApplicationContext(),PreTwoWheelDashboard.class);
                startActivity(intent);
            }
            else {
                String vehicle="Car";
                BookingHelper bookingHelper = new BookingHelper(vehicle, username, contact_number, vehicle_model, vehicle_number, date, time);

                databaseReference.child(contact_number).setValue(bookingHelper);
                Toast.makeText(this, "added", Toast.LENGTH_LONG).show();
                Intent intent=new Intent(getApplicationContext(),PreFourWheelDashboard.class);
                startActivity(intent);
            }



        }else {
            Toast.makeText(this,"enter a value",Toast.LENGTH_LONG).show();
        }

    }


}