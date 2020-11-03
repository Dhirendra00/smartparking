package com.example.finalyear;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class BookingDetail extends AppCompatActivity {

    EditText editTextUsername, editTextContactNumber, editTextVehicleModel,editTextVehicleNumber,editTextDate,editTextTime,editTextVehicleType;
    Button btnUpdate;
    FirebaseDatabase root;
    DatabaseReference databaseParking;
    String _CONTACTNUMBER,_DATE,_TIME,_USERNAME,_VEHICLE,_VEHICLEMODEL,_VEHICLENUMBER;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_detail);

        root=FirebaseDatabase.getInstance();
        databaseParking= root.getReference("parking");


        editTextContactNumber= (EditText) findViewById(R.id.editTextContactNumber);
        editTextDate=(EditText) findViewById(R.id.editTextDate);
        editTextTime=(EditText) findViewById(R.id.editTextTime);
        editTextUsername= (EditText) findViewById(R.id.editTextUsername);
        editTextVehicleType=(EditText) findViewById(R.id.editTextVehicleType);
        editTextVehicleModel= (EditText) findViewById(R.id.editTextVehicleModel);
        editTextVehicleNumber= (EditText) findViewById(R.id.editTextVehicleNumber);
        btnUpdate= findViewById(R.id.btnUpdate);
                viewData();
    }


    private void viewData() {
        Intent intent=getIntent();
        String CONTACTNUMBER=intent.getStringExtra("contact_number");
        String DATE=intent.getStringExtra("date");
        String TIME=intent.getStringExtra("time");
        String VEHICLE=intent.getStringExtra("vehicle");
        String USERNAME=intent.getStringExtra("username");
        String VEHICLEMODEL=intent.getStringExtra("vehicle_model");
        String VEHICLENUMBER=intent.getStringExtra("vehicle_number");

        editTextContactNumber.setText(CONTACTNUMBER);
        editTextDate.setText(DATE);
        editTextTime.setText(TIME);
        editTextVehicleType.setText(VEHICLE);
        editTextUsername.setText(USERNAME);
        editTextVehicleNumber.setText(VEHICLENUMBER);
        editTextVehicleModel.setText(VEHICLEMODEL);



    }
    public void updateData(View view){
        if (isDateChanged() || isTimeChanged() || isVehicleChanged() || isUsernameChanged() || isvehicleModelChanged() || isVehicleNumberChanged()){
            Toast.makeText(BookingDetail.this,"Data Updated Successfully",Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(BookingDetail.this, "Data Has Not Modified", Toast.LENGTH_LONG).show();
        }
    }

    private boolean isDateChanged() {
        if (!_DATE.equals(editTextDate.getText().toString())){
            databaseParking.child(_CONTACTNUMBER).child("date").setValue(editTextDate.getText().toString());
            return true;

        }else{
            return false;
        }
    }

    private boolean isTimeChanged() {
        if (!_TIME.equals(editTextTime.getText().toString())){
            databaseParking.child(_CONTACTNUMBER).child("time").setValue(editTextTime.getText().toString());
            return true;

        }else{
            return false;
        }
    }

    private boolean isVehicleChanged() {
        if (!_VEHICLE.equals(editTextVehicleType.getText().toString())){
            databaseParking.child(_CONTACTNUMBER).child("vehicle").setValue(editTextVehicleType.getText().toString());
            return true;

        }else{
            return false;
        }
    }

    private boolean isUsernameChanged() {
        if (!_USERNAME.equals(editTextUsername.getText().toString())){
            databaseParking.child(_CONTACTNUMBER).child("username").setValue(editTextUsername.getText().toString());
            return true;

        }else{
            return false;
        }
    }

    private boolean isvehicleModelChanged() {
        if (!_VEHICLEMODEL.equals(editTextVehicleModel.getText().toString())){
            databaseParking.child(_CONTACTNUMBER).child("vehicle_model").setValue(editTextVehicleModel.getText().toString());
            return true;

        }else{
            return false;
        }
    }

    private boolean isVehicleNumberChanged() {
        if (!_VEHICLENUMBER.equals(editTextVehicleNumber.getText().toString())){
            databaseParking.child(_CONTACTNUMBER).child("vehicle_number").setValue(editTextVehicleNumber.getText().toString());
            return true;

        }else{
            return false;
        }
    }


}