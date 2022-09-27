package com.example.calculater;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivityPolicies extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_policies);
        String text = getIntent().getStringExtra("key1");
        if(findViewById(R.id.rovno) instanceof TextView){
            ((TextView) findViewById(R.id.rovno)).setText(text);
        }
        findViewById(R.id.delenie).setOnClickListener(view -> {
            Intent homeIntent = new Intent(Intent.ACTION_MAIN);
            homeIntent.addCategory( Intent.CATEGORY_HOME );
            homeIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(homeIntent);
            System.exit(1);
        });
    }
}
