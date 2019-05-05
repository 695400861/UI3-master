package com.example.ui3;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

public class XML_menu extends AppCompatActivity {
    private EditText te;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xml_menu);
        te = (EditText) findViewById(R.id.editText);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.toast:
                Toast.makeText(this, "selected " + item.getTitle(), Toast.LENGTH_SHORT).show();
                return super.onOptionsItemSelected(item);
            case R.id.red:
                te.setTextColor(Color.RED);
                return true;
            case R.id.black:
                te.setTextColor(Color.BLACK);
                return true;
            case R.id.big:
                te.setTextSize(30);
                return true;
            case R.id.middle:
                te.setTextSize(20);
                return true;
            case R.id.small:
                te.setTextSize(10);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}