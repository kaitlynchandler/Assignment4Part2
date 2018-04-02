package com.example.kaitlynchandler.assignment4part2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by kaitlynchandler on 3/26/18.
 */

public class EnterValues extends Activity {

    DatabaseHelper db = new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_values);
    }
    public void storeSynonyms(View view){
        if(view.getId() == R.id.submitB){


            EditText first = (EditText)findViewById(R.id.word1);
            String word1 = first.getText().toString();
            EditText second = (EditText)findViewById(R.id.word2);
            String word2 = second.getText().toString();
            Synonyms s = new Synonyms();
            s.setSynonym2(word2);
            s.setSynonym1(word1);



                Intent i = new Intent(EnterValues.this, MainActivity.class);
                startActivity(i);
            }

        }
    }
