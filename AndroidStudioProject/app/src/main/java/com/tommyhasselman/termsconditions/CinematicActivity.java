package com.tommyhasselman.termsconditions;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.tommyhasselman.termsconditions.model.Cinematic;

public class CinematicActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cinematic);
        Cinematic c = new Cinematic();
        //c.Scenario s = new c.Scenario();
    }
}
