package com.example.aad_studentdetails;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //
    private Spinner spinCountry;

    //AutoCompleteTextView
    private AutoCompleteTextView autoCompleteTextView;
    private String[] batch = {"19A","19B","20A","20B","21A","21B","22A","22B","22C","23A","23B"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinCountry = findViewById(R.id.spinCountry);

        String countries[] = {"Nepal","India","China","Pakistan","US","UK","Bangladesh","Russia","Spain","Germany"};

        ArrayAdapter adapter = new ArrayAdapter<>
                (
            this,
            android.R.layout.simple_list_item_1, countries
            );

        spinCountry.setAdapter(adapter);


        spinCountry.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(MainActivity.this, spinCountry.getSelectedItem().toString(),Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        autoCompleteTextView = findViewById(R.id.actvBatch);

        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<>(
                this, android.R.layout.select_dialog_item,batch
        );

        autoCompleteTextView.setAdapter(stringArrayAdapter);
        autoCompleteTextView.setThreshold(1);


    }
}
