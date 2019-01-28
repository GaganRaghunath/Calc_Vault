package com.pirateapps.jack.calcvault;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.net.MalformedURLException;
import java.net.URL;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener{

    public static final int ACTIVITY_ADD_ENTRY = 1;

    private DBHelper dbHelper;
    private TextView nameTextView;
    private TextView numberTextView;
    private TextView emailTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        dbHelper = new DBHelper(this);
        dbHelper.initialise();

        nameTextView = findViewById(R.id.textViewName);
        numberTextView =  findViewById(R.id.textViewNumber);
        emailTextView =  findViewById(R.id.textViewEmail);
        Button btn1_next = findViewById(R.id.btn_next);
        Button btn1_prev = findViewById(R.id.btn_prev);
        ImageButton btn1_add = findViewById(R.id.imageButton1);
        ImageButton btn1_del = findViewById(R.id.imageButton2);

        btn1_add.setOnClickListener(this);
        btn1_prev.setOnClickListener(this);
        btn1_next.setOnClickListener(this);
        btn1_del.setOnClickListener(this);

        showFirstEntry();
    }

    public String whatsappUrl(){

        final String BASE_URL = "https://api.whatsapp.com/";
        final String WHATSAPP_PHONE_NUMBER = "91"+String.valueOf(nameTextView);
        final String PARAM_PHONE_NUMBER = "phone=";
        final String PARAM_TEXT = "&text=";
        final String TEXT_VALUE = "Hello, How are you ?";

        String newUrl = BASE_URL + "send?";

        Uri builtUri = Uri.parse(newUrl).buildUpon()
                .appendQueryParameter(PARAM_PHONE_NUMBER, WHATSAPP_PHONE_NUMBER)
                .appendQueryParameter(PARAM_TEXT, TEXT_VALUE)
                .build();

        return String.valueOf(buildUrl(builtUri.toString()));
    }

    @Override
    protected void onDestroy() {
        dbHelper.close();

        super.onDestroy();
    }


    public void updateContactOnScreen(String[] entry) {
        nameTextView.setText(entry[0]);
        numberTextView.setText(entry[1]);
        emailTextView.setText(entry[2]);
    }

    public void showFirstEntry() {
        String[] entry = dbHelper.getFirstEntry();

        if (entry != null) {
            updateContactOnScreen(entry);
        }
    }


    public void showLastEntry() {
        String[] entry = dbHelper.getLastEntry();

        if (entry != null) {
            updateContactOnScreen(entry);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == ACTIVITY_ADD_ENTRY) {
            if (resultCode == RESULT_OK) {
                dbHelper.refreshDBEntries();

                showLastEntry();
            }
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_next:
                String[] entry = dbHelper.getNextEntry();

                if (entry != null) {
                    updateContactOnScreen(entry);
                } else {
                    Toast.makeText(this, "No more entries to show", Toast.LENGTH_SHORT)
                            .show();
                }
                break;

            case R.id.btn_prev:
                String[] entry1 = dbHelper.getPreviousEntry();

                if (entry1 != null) {
                    updateContactOnScreen(entry1);
                } else {
                    Toast.makeText(this, "No more entries to show", Toast.LENGTH_SHORT)
                            .show();
                }
                break;

            case R.id.imageButton1:
                Intent myIntent = new Intent(this, AddEntryActivity.class);
                startActivityForResult(myIntent, ACTIVITY_ADD_ENTRY);
                break;

            case R.id.imageButton2:
                boolean entryDeleted = dbHelper.deleteCurrentEntry();

                if (entryDeleted) {
                    String[] entry2 = dbHelper.getNextEntry();

                    if (entry2 != null) {
                        updateContactOnScreen(entry2);
                    } else {
                        entry2 = dbHelper.getPreviousEntry();

                        if (entry2 != null) {
                            updateContactOnScreen(entry2);
                        } else {
                            entry2 = new String[] { " ", " ", " " };

                            updateContactOnScreen(entry2);
                        }
                    }
                } else {
                    Toast.makeText(this, "Nothing to delete", Toast.LENGTH_SHORT)
                            .show();
                }
                break;

            case R.id.btn_whatsapp:
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(whatsappUrl()));
                startActivity(intent);

            }

    }


    private static URL buildUrl(String s) {
        URL finalUrl = null;
        try {
            finalUrl = new URL(s);
        } catch (MalformedURLException e) {
            e.printStackTrace();

        }
        return finalUrl;
    }
}
