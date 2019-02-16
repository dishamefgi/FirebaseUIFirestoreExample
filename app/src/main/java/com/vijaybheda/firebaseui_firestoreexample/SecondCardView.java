package com.vijaybheda.firebaseui_firestoreexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

public class SecondCardView extends AppCompatActivity {

    ImageView mAddDoctor,mDCRListView,mProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_card_view);

        mAddDoctor=findViewById(R.id.dcrEntryCard);
        mAddDoctor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),NewDoctorActivity.class);
                startActivity(intent);
            }
        });

        mDCRListView=findViewById(R.id.dcrlistview);
        mDCRListView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });

        mProfile=findViewById(R.id.imgProfile);
        mProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),EmpProfileActivity.class);
                startActivity(intent);
            }
        });
    }
}
