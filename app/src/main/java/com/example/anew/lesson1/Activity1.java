package com.example.anew.lesson1;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.TreeSet;

public class Activity1 extends AppCompatActivity {

    private EditText editTextName;
    private Button btnInfo;
    private Button btnAdd;
    private TextView txtView;
    private ArrayList<String> students = new ArrayList<>();


    public static Intent createStartIntent(Context context){

        Intent intent = new Intent(context, Activity1.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);

        editTextName = findViewById(R.id.editText);
        btnInfo = findViewById(R.id.button);
        btnAdd = findViewById(R.id.button4);
        txtView = findViewById(R.id.textView);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                students.add(editTextName.getText().toString());
                editTextName.setText("");

            }
        });

        btnInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TreeSet<String> sortStudents = new TreeSet<>(students);
                Iterator<String> iterator =  sortStudents.iterator();
                StringBuilder nameStudents = new StringBuilder();

                while (iterator.hasNext()) {
                    nameStudents = nameStudents.append(iterator.next()).append("\n");
                }
                txtView.setText(nameStudents);

            }
        });


    }
}
