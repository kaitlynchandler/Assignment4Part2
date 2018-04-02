package com.example.kaitlynchandler.assignment4part2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/**
 * Created by kaitlynchandler on 3/26/18.
 */

public class Results extends Activity{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        TextView tv = (TextView) findViewById(R.id.results);

        String synonym = getIntent().getStringExtra("Synonym");

        tv.setText(synonym);

    }
    public void goHome(View view){
        if(view.getId() == R.id.homeB){
            Intent i = new Intent(Results.this, MainActivity.class);
            startActivity(i);
        }

    }
}