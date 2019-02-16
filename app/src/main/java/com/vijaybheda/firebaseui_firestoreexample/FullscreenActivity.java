package com.vijaybheda.firebaseui_firestoreexample;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class FullscreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fullscreen);

        Thread t=new Thread()
        {
            public void run()
            {
                try
                {
                    sleep(2000);
                }
                catch (InterruptedException e) {
                    // TODO: handle exception
                    e.printStackTrace();
                }
                Intent i=new Intent(getApplicationContext(), SecondCardView.class);
//                Intent i=new Intent(getApplicationContext(), EmployeeDetails.class);
                startActivity(i);
                finish();
            }
        };
        t.start();

    }
}
