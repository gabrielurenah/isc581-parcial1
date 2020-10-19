package com.pucmm.fragments;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.pucmm.fragments.Classes.Concept;

public class BodyActivity extends AppCompatActivity {

    private TextView mTitle;
    private TextView mBody;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.body_fragment);

        mTitle = findViewById(R.id.txt_title);
        mBody = findViewById(R.id.txt_body);

        Bundle extras = getIntent().getExtras();

        mTitle.setText(Concept.concepts[extras.getInt("position")]);
        mBody.setText(Concept.description[extras.getInt("position")]);

    }
}