package com.example.android.hellosharedprefs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Switch;
import android.widget.TextView;

public class SharedPreferenceActivity extends AppCompatActivity {

    private int mCount = 0;
    private int mColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preference);
        Bundle extras = getIntent().getExtras();
        mCount = extras.getInt("Count");
        mColor = extras.getInt("Color");
    }

    public void onClick(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        int buttonID = view.getId();

        switch (buttonID) {
            case R.id.save:
                intent.putExtra("Count", mCount);
                intent.putExtra("Color", mColor);
                intent.putExtra("Action", 1);
                break;
            case R.id.reset:
                intent.putExtra("Action", 2);
                break;
        }
        startActivity(intent);
    }
}