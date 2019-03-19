package com.vijaybheda.firebaseui_firestoreexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ProductListViewActivity extends AppCompatActivity {

    FirebaseDatabase database;
    DatabaseReference myRef;
    List<FireModel> list;
    RecyclerView recycle;
    Button view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list_view);

        view = (Button) findViewById(R.id.view);
        recycle = (RecyclerView) findViewById(R.id.recycle);
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("message");

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                list = new ArrayList<FireModel>();
                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {

                    FireModel value = dataSnapshot1.getValue(FireModel.class);
                    FireModel fire = new FireModel();
                    String name = value.getName();
                    String address = value.getAddress();
                    String email = value.getEmail();
                    fire.setName(name);
                    fire.setEmail(email);
                    fire.setAddress(address);
                    list.add(fire);

                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("Hello", "Failed to read value.", error.toException());
            }
        });

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RecyclerAdapter recyclerAdapter = new RecyclerAdapter(list, getApplicationContext());
                RecyclerView.LayoutManager recyce = new GridLayoutManager(getApplicationContext(), 2);
                /// RecyclerView.LayoutManager recyce = new LinearLayoutManager(MainActivity.this);
                // recycle.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(10), true));
                recycle.setLayoutManager(recyce);
                recycle.setItemAnimator(new DefaultItemAnimator());
                recycle.setAdapter(recyclerAdapter);
            }
        });
    }
}
