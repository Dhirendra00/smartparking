package com.example.finalyear;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.hbb20.CountryCodePicker;

public class OtpNumberActivity extends AppCompatActivity {
    EditText phoneNumber;
    CountryCodePicker countryCodePicker;
    Button signup;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp_number);

        countryCodePicker=findViewById(R.id.country_code_picker);
        phoneNumber=findViewById(R.id.phone_number);
        signup=findViewById(R.id.signup);



        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logIn();

            }
        });



    }
    private void logIn(){
        final String userEnteredNumber=phoneNumber.getText().toString().trim();
        DatabaseReference reference= FirebaseDatabase.getInstance().getReference("parking");
        Query checkLogin=reference.orderByChild("contact_number").equalTo(userEnteredNumber);
        checkLogin.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    String verification =  snapshot.child(userEnteredNumber).child("contact_number").getValue(String.class);
                    if (verification.equals(userEnteredNumber)){
                        String fb_contact_number= snapshot.child(userEnteredNumber).child("contact_number").getValue(String.class);
                        String fb_date= snapshot.child(userEnteredNumber).child("date").getValue(String.class);
                        String fb_time= snapshot.child(userEnteredNumber).child("time").getValue(String.class);
                        String fb_username= snapshot.child(userEnteredNumber).child("username").getValue(String.class);
                        String fb_vehicle= snapshot.child(userEnteredNumber).child("vehicle").getValue(String.class);
                        String fb_vehicle_model= snapshot.child(userEnteredNumber).child("vehicle_model").getValue(String.class);
                        String fb_vehicle_number= snapshot.child(userEnteredNumber).child("vehicle_number").getValue(String.class);

                        Intent intent=new Intent(getApplicationContext(),BookingDetail.class);
                        intent.putExtra("contact_number",fb_contact_number);
                        intent.putExtra("date",fb_date);
                        intent.putExtra("time",fb_time);
                        intent.putExtra("username",fb_username);
                        intent.putExtra("vehicle",fb_vehicle);
                        intent.putExtra("vehicle_model",fb_vehicle_model);
                        intent.putExtra("vehicle_number",fb_vehicle_number);

                        startActivity(intent);

                    }
                    Toast.makeText(OtpNumberActivity.this,"Invalid Number",Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(OtpNumberActivity.this,"No such Number",Toast.LENGTH_SHORT).show();
                }


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }



//    public void callverifyOTPScreen(View view) {
//        String _getUserEnteredPhoneNumber= phoneNumber.getEditableText().toString().trim();
//        String _phoneNo= "+"+countryCodePicker.getFullNumber()+_getUserEnteredPhoneNumber;
//        Intent intent=new Intent(getApplicationContext(), VerifyOTP.class);
//
//        intent.putExtra("phoneNo",_phoneNo);
//    }
}