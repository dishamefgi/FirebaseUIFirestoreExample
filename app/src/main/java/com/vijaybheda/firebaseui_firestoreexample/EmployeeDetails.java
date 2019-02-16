package com.vijaybheda.firebaseui_firestoreexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class EmployeeDetails extends AppCompatActivity implements View.OnClickListener {

    CardView mFSCardView, mDoctorCardView, mPurchaseCardView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_details);

        mFSCardView=findViewById(R.id.fsCardView); mDoctorCardView=findViewById(R.id.doctorCardView); mPurchaseCardView=findViewById(R.id.purchaseCardView);
        mFSCardView.setOnClickListener(this); mDoctorCardView.setOnClickListener(this); mPurchaseCardView.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        mFSCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "mFSCardView", Toast.LENGTH_SHORT).show();
            }
        });

        mDoctorCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "mDoctorCardView", Toast.LENGTH_SHORT).show();
            }
        });

        mPurchaseCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "mPurchaseCardView", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
