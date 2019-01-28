package com.pirateapps.jack.calcvault;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;

public class AddEntryActivity extends AppCompatActivity {

    private DBHelper dbHelper;
    private EditText nameEntry;
    private EditText numberEntry;
    private EditText emailEntry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_entry);

        dbHelper = new DBHelper(this);
        dbHelper.initialise();

        nameEntry = findViewById(R.id.editTextName);
        numberEntry = findViewById(R.id.editTextNumber);
        emailEntry = findViewById(R.id.editTextEmail);
    }

    @Override
    protected void onDestroy() {
        dbHelper.close();

        super.onDestroy();
    }


    private boolean isStringEmpty(String input) {
        return input.trim().isEmpty();
    }

    private boolean isEmailValid(String email) {
        Pattern emailPattern = Patterns.EMAIL_ADDRESS;
        return emailPattern.matcher(email).matches();
    }


    public void addEntry(View v) {
        String name = nameEntry.getText().toString();
        String number = numberEntry.getText().toString();
        String email = emailEntry.getText().toString();

        if (isStringEmpty(name)) {
            Toast.makeText(this, "You must enter a name", Toast.LENGTH_SHORT)
                    .show();
            return;
        }

        if (isStringEmpty(number) && isStringEmpty(email)) {
            Toast.makeText(this,
                    "You must enter either a number or an email address",
                    Toast.LENGTH_SHORT).show();
            return;
        }

        if (!isStringEmpty(email) && !isEmailValid(email)) {
            Toast.makeText(this, "Email address is invalid", Toast.LENGTH_SHORT)
                    .show();
            return;
        }

        Boolean newEntryAdded = dbHelper.addNewEntry(name, number, email);

        if (newEntryAdded) {
            Toast.makeText(this, "Entry added", Toast.LENGTH_SHORT).show();

            setResult(RESULT_OK);
            finish();
        } else {
            Toast.makeText(this, "Something went wrong, please try again.",
                    Toast.LENGTH_SHORT).show();
        }
    }

    public void cancelEntry(View v) {
        setResult(RESULT_CANCELED);
        finish();
    }
}
