package com.vijaybheda.firebaseui_firestoreexample;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.NumberPicker;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Calendar;

import androidx.appcompat.app.AppCompatActivity;

public class NewDoctorActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editTextTitle, editTextDescription, editTextRetailerNameCode, editTextCoNo, editTextDrEmail;
    private NumberPicker numberPickerPriority;
    private RatingBar ratebar;

    private int date, month, year, hour, min,firstDayOfWeek;
    Spinner spinner;
    TextView datetxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_doctor);

        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_close);
        setTitle("Add Doctor Call");

        datetxt = findViewById(R.id.datetext);
        editTextTitle = findViewById(R.id.edit_text_title);
        editTextDescription = findViewById(R.id.edit_text_description);
        editTextRetailerNameCode = findViewById(R.id.edit_text_RetailerNameCode);
        editTextCoNo = findViewById(R.id.edit_text_CoNo);
        editTextDrEmail = findViewById(R.id.edit_text_DrEmail);
        spinner= findViewById(R.id.spinner);
        ratebar = findViewById(R.id.ratebar);
        /*numberPickerPriority = findViewById(R.id.number_picker_priority);
        numberPickerPriority.setMinValue(1);
        numberPickerPriority.setMaxValue(99);*/

       /* String[] countries=getResources().getStringArray(R.array.array_countries);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,R.id.text, countries);
        spinner.setAdapter(adapter);*/
        pickDate();


        String[] speciality_list=getResources().getStringArray(R.array.array_speciality);
        ArrayAdapter<String> SpecialityAdapter=new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item, speciality_list);
        spinner.setAdapter(SpecialityAdapter);
    }

    private void pickDate() {

        final Calendar calendar = Calendar.getInstance();
        date = calendar.get(Calendar.DAY_OF_MONTH);
        month = calendar.get(Calendar.MONTH);
        year = calendar.get(Calendar.YEAR);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker datePicker, int year, int monthOfYear, int dayOfMonth) {
                datetxt.setText(dayOfMonth + "/" + (monthOfYear) + 1 + "/" + year);
            }
        }, date, month, year);
        datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis()-500000000);
        datePickerDialog.getDatePicker().setMaxDate(System.currentTimeMillis()+100);
        datePickerDialog.show();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.new_note_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.save_doctor:
                saveDoctor();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    int count;// should fetch latest dcr number from firebase and store in count

    int getCount() {
        count++;
        return count;
    }

    private void saveDoctor() {
        String title = editTextTitle.getText().toString();
        String description = editTextDescription.getText().toString();
        String retailerNameCode = editTextRetailerNameCode.getText().toString();
        String DrCoNo = editTextCoNo.getText().toString();
        String DrEmail = editTextDrEmail.getText().toString();
        String rate = String.valueOf(ratebar.getRating());
        String spec = spinner.getSelectedItem().toString();
        int priority = getCount();

        if (title.trim().isEmpty() || description.trim().isEmpty() || retailerNameCode.trim().isEmpty() || DrCoNo.trim().isEmpty() || DrEmail.trim().isEmpty() || rate.trim().isEmpty()) {
            Toast.makeText(this, "Please insert a value", Toast.LENGTH_SHORT).show();
            return;
        }

        CollectionReference doctorbookRef = FirebaseFirestore.getInstance()
                .collection("EntryBook");
        doctorbookRef.add(new Note(title, description, retailerNameCode, DrCoNo, DrEmail, rate, priority,spec));
        Toast.makeText(this, "DCR added", Toast.LENGTH_SHORT).show();
        finish();
    }

    @Override
    public void onClick(View view) {
        datetxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pickDate();
            }
        });
    }
}
