package com.example.anew.lesson1;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


public class Activity2 extends AppCompatActivity {

    private EditText editTextLearner;
    private Button btnLearner;
    private TextView textViewLearner;
    private String[] parts;
    private Student student;
    private String infoAll;
    private Map<Long, String> hashMap = new HashMap<>();


    public static Intent createStartIntent(Context context) {
        Intent intent = new Intent(context, Activity2.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);



        editTextLearner = findViewById(R.id.editLearner);
        btnLearner = findViewById(R.id.btnLearner);
        textViewLearner = findViewById(R.id.infoLearner);


        editTextLearner.setOnKeyListener(new View.OnKeyListener()
        {
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if ((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER))
                {
                    Toast.makeText(Activity2.this, editTextLearner.getText(), Toast.LENGTH_SHORT).show();

                    infoAll = editTextLearner.getText().toString();
                    parts = infoAll.split(" ");
                    student = new Student(parts[0], parts[1], parts[2], parts[3]);
                    hashMap.put(student.id,student.info());
                    editTextLearner.setText("");

                    return true;
                }
                return false; }
        });

        btnLearner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String info = hashMap.values() + "\n";
                textViewLearner.setText(info);

            }
        });


    }




}
