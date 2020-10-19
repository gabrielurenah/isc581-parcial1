package com.pucmm.fragments;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class FragmentActivity extends AppCompatActivity {

    private TextView mTitle;
    private TextView mBody;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.article_fragment);
        Bundle extras = getIntent().getExtras();
        mTitle = findViewById(R.id.txt_title);
        mBody = findViewById(R.id.txt_body);

        mTitle.setText(extras.getString("title"));
        mBody.setText(extras.getString("body"));

    }
}