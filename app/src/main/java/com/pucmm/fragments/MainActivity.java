package com.pucmm.fragments;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class MainActivity extends FragmentActivity implements TitlesFragment.OnHeadlineSelectedListener {

    private int orientation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (findViewById(R.id.fragment_container) != null) {
            if (savedInstanceState != null) {
                return;
            }

            TitlesFragment firstFragment = new TitlesFragment();
            firstFragment.setArguments(getIntent().getExtras());

            getSupportFragmentManager().beginTransaction().add(R.id.fragment_container,firstFragment).commit();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        orientation = getResources().getConfiguration().orientation;
        
    }

    @Override
    public void onArticleSelected(int position) {
        BodyFragment af = (BodyFragment) getSupportFragmentManager().findFragmentById(R.id.article_fragment);

        if (af != null) {

            af.updateArticleView(position);
        } else {
            BodyFragment newFragment = new BodyFragment();
            Bundle args = new Bundle();

            args.putInt(BodyFragment.ARG_POSITION, position);
            newFragment.setArguments(args);
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.fragment_container, newFragment);
            transaction.addToBackStack(null);
            transaction.commit();
        }

    }
}