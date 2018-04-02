package com.example.kaitlynchandler.assignment4part2;



import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = new DatabaseHelper(this);
    }

    public void enterValues(View view) {
        if (view.getId() == R.id.enterValsB) {

            Intent i = new Intent(MainActivity.this, EnterValues.class);
            startActivity(i);

        }

    }

    public void findSynonym(View view) {
        if (view.getId() == R.id.findSynB) {

            EditText wordEntered = (EditText) findViewById(R.id.userInput);
            String enteredWord = wordEntered.getText().toString();


            Cursor data = db.getAllData();
            if (data.getCount() == 0) {
                Toast.makeText(MainActivity.this, "Not available", Toast.LENGTH_SHORT).show();
                return;
            }
            String result = enteredWord + " not found";
            data.moveToFirst();
            do {
                if (data.getString(1).equalsIgnoreCase(enteredWord)) {
                    result = data.getString(2);
                    break;
                }
            }
            while (data.moveToNext());


            Intent i = new Intent(MainActivity.this, Results.class);
            i.putExtra("Synonym", result);
            startActivity(i);
        }
    }
}
