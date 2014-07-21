package com.example.sherlock.sherlockapp;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.sherlock.sherlockapp.R;

public class IdentityPerson extends ActionBarActivity {

    public final static String THIEF = "com.example.sherlock.THIEF";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_identity_person);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.identity_person, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void onRadioClick(View v)
    {
        Intent answerIntent = new Intent();

        switch (v.getId()){
            case R.id.radioDog:
                answerIntent.putExtra(THIEF, "Это все бодрый пес");
                break;
            case R.id.radioCrow:
                answerIntent.putExtra(THIEF, "Сперла паршивая ворона");
                break;
            case R.id.radioCat:
                answerIntent.putExtra(THIEF, "Василий постарался!");
                break;
            default:
                break;
        }

        setResult(RESULT_OK, answerIntent);
        finish();
    }
}
