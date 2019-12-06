package com.example.myfirsthelloapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class FinishActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        finish();
    }
}
