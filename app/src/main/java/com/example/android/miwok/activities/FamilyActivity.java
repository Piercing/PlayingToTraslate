package com.example.android.miwok.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.android.miwok.R;
import com.example.android.miwok.fragments.FamilyFragment;

public class FamilyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, new FamilyFragment())
                .commit();
    }
}